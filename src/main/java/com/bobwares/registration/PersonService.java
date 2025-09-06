/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonService.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonService
 * Description: Service layer providing asynchronous CRUD operations for Person entities backed by an in-memory store.
 */
package com.bobwares.registration;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Manages {@link Person} entities in a thread-safe in-memory store using reactive types.
 */
@Service
public class PersonService {

    private final ConcurrentMap<UUID, Person> store = new ConcurrentHashMap<>();

    /**
     * Creates a new person from the supplied request.
     *
     * @param request validated request payload
     * @return asynchronous publisher yielding the created person
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
     * @return publisher emitting the person or error if not found
     */
    public Mono<Person> get(UUID id) {
        Person person = store.get(id);
        if (person == null) {
            return Mono.error(new PersonNotFoundException(id));
        }
        return Mono.just(person);
    }

    /**
     * Updates an existing person with new data.
     *
     * @param id      identifier of person to update
     * @param request validated request payload
     * @return publisher emitting the updated person
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
     * @param id person identifier
     * @return empty publisher on success, error if person missing
     */
    public Mono<Void> delete(UUID id) {
        Person removed = store.remove(id);
        if (removed == null) {
            return Mono.error(new PersonNotFoundException(id));
        }
        return Mono.empty();
    }
}

