/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonService.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonService
 * Description: Service providing asynchronous CRUD operations backed by an in-memory store.
 */
package com.bobwares.registration;

import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * In-memory service managing {@link Person} instances.
 */
public class PersonService {
    private final ConcurrentMap<UUID, Person> store = new ConcurrentHashMap<>();

    /**
     * Persists a new person constructed from the request.
     *
     * @param request incoming person data
     * @return saved person
     */
    public Mono<Person> create(PersonRequest request) {
        Person person = Person.from(request);
        store.put(person.id(), person);
        return Mono.just(person);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id unique identifier
     * @return person mono or error when not found
     */
    public Mono<Person> get(UUID id) {
        Person person = store.get(id);
        return person != null ? Mono.just(person) : Mono.error(new PersonNotFoundException(id));
    }

    /**
     * Updates an existing person using request data.
     *
     * @param id      existing identifier
     * @param request incoming person data
     * @return updated person or error when not found
     */
    public Mono<Person> update(UUID id, PersonRequest request) {
        if (!store.containsKey(id)) {
            return Mono.error(new PersonNotFoundException(id));
        }
        Person updated = Person.from(id, request);
        store.put(id, updated);
        return Mono.just(updated);
    }

    /**
     * Deletes a person by identifier.
     *
     * @param id unique identifier
     * @return completion signal or error when not found
     */
    public Mono<Void> delete(UUID id) {
        Person removed = store.remove(id);
        return removed != null ? Mono.empty() : Mono.error(new PersonNotFoundException(id));
    }
}
