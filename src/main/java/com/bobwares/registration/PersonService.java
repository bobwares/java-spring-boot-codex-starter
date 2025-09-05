/**
 * App: common
 * Package: com.bobwares.registration
 * File: PersonService.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: PersonService
 * Description: Service layer managing person persistence in an in-memory store.
 */
package com.bobwares.registration;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Provides CRUD operations for {@link Person} objects using a thread-safe in-memory store.
 */
@Service
public class PersonService {

    private final Map<UUID, Person> store = new ConcurrentHashMap<>();

    /**
     * Creates and stores a new person.
     *
     * @param request person data
     * @return created person
     */
    public Mono<Person> create(PersonRequest request) {
        Person person = Person.from(request);
        store.put(person.id(), person);
        return Mono.just(person);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id person identifier
     * @return person or error if not found
     */
    public Mono<Person> get(UUID id) {
        return Mono.justOrEmpty(store.get(id))
                .switchIfEmpty(Mono.error(new PersonNotFoundException(id)));
    }

    /**
     * Updates an existing person.
     *
     * @param id      identifier
     * @param request updated data
     * @return updated person
     */
    public Mono<Person> update(UUID id, PersonRequest request) {
        return get(id).flatMap(existing -> {
            Person updated = Person.from(id, request);
            store.put(id, updated);
            return Mono.just(updated);
        });
    }

    /**
     * Deletes a person by identifier.
     *
     * @param id identifier
     * @return completion signal
     */
    public Mono<Void> delete(UUID id) {
        store.remove(id);
        return Mono.empty();
    }
}

