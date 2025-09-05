/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonService.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonService
 * Description: Application service providing asynchronous CRUD operations backed by an in-memory, thread-safe
 *              store.
 */
package com.bobwares.registration;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import reactor.core.publisher.Mono;

/**
 * Handles persistence operations for {@link Person} instances using a concurrent map.
 */
public class PersonService {

    private final ConcurrentMap<UUID, Person> store = new ConcurrentHashMap<>();

    /**
     * Creates a new person and stores it.
     *
     * @param request validated request payload
     * @return asynchronous result containing the created person
     */
    public Mono<Person> create(PersonRequest request) {
        Person person = Person.from(request);
        store.put(person.id(), person);
        return Mono.just(person);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id identifier of the person
     * @return asynchronous result containing the person if found
     * @throws PersonNotFoundException when the id is not present
     */
    public Mono<Person> get(UUID id) {
        Person person = store.get(id);
        if (person == null) {
            return Mono.error(new PersonNotFoundException(id));
        }
        return Mono.just(person);
    }

    /**
     * Updates an existing person with new attributes.
     *
     * @param id identifier of the person to update
     * @param request validated request payload
     * @return asynchronous result containing the updated person
     * @throws PersonNotFoundException when the id is not present
     */
    public Mono<Person> update(UUID id, PersonRequest request) {
        if (!store.containsKey(id)) {
            return Mono.error(new PersonNotFoundException(id));
        }
        Person person = Person.from(id, request);
        store.put(id, person);
        return Mono.just(person);
    }

    /**
     * Deletes a person by identifier.
     *
     * @param id identifier of the person to remove
     * @return completion signal when deletion is finished
     * @throws PersonNotFoundException when the id is not present
     */
    public Mono<Void> delete(UUID id) {
        Person removed = store.remove(id);
        if (removed == null) {
            return Mono.error(new PersonNotFoundException(id));
        }
        return Mono.empty();
    }
}
