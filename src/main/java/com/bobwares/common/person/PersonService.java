/**
 * App: common
 * Package: com.bobwares.common.person
 * File: PersonService.java
 * Version: 0.1.0
 * Turn #: 1
 * Author: AI
 * Date: 2025-09-04T23:36:46Z
 * Exports: PersonService, get, put, update, delete
 * Description: In-memory asynchronous CRUD operations for Person records.
 *              Provides non-blocking reactive methods for basic storage.
 */

package com.bobwares.common.person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

@Service
public class PersonService {

    private final Map<String, Person> store = new ConcurrentHashMap<>();

    public Mono<Person> get(String id) {
        return Mono.justOrEmpty(store.get(id))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Mono<Person> put(String id, Person person) {
        store.put(id, person);
        return Mono.just(person);
    }

    public Mono<Person> update(String id, Person person) {
        return Mono.justOrEmpty(store.computeIfPresent(id, (k, v) -> person))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Mono<Void> delete(String id) {
        return Mono.justOrEmpty(store.remove(id))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .then();
    }
}
