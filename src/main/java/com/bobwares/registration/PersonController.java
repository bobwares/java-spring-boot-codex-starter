/**
 * App: common
 * Package: com.bobwares.registration
 * File: PersonController.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: PersonController
 * Description: REST controller exposing asynchronous CRUD operations for persons.
 */
package com.bobwares.registration;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * Asynchronous REST endpoints for person management.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * Creates a new person.
     *
     * @param request request payload
     * @return created person
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> create(@Validated @RequestBody PersonRequest request) {
        return service.create(request);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id person identifier
     * @return requested person
     */
    @GetMapping("/{id}")
    public Mono<Person> get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Updates a person.
     *
     * @param id      identifier
     * @param request update payload
     * @return updated person
     */
    @PutMapping("/{id}")
    public Mono<Person> update(@PathVariable UUID id, @Validated @RequestBody PersonRequest request) {
        return service.update(id, request);
    }

    /**
     * Deletes a person.
     *
     * @param id identifier
     * @return completion signal
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}

