/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonController.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonController
 * Description: REST controller exposing asynchronous CRUD endpoints for Person resources with OpenAPI documentation.
 */
package com.bobwares.registration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Exposes RESTful endpoints for managing {@link Person} entities.
 */
@RestController
@RequestMapping("/api/persons")
@Validated
@Tag(name = "Persons", description = "Asynchronous CRUD for persons")
public class PersonController {

    private final PersonService service;

    /**
     * Constructs the controller with its required dependencies.
     *
     * @param service person service managing data operations
     */
    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * Creates a new person.
     *
     * @param request person payload
     * @return created person
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create person", description = "Creates a new person")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Person created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public Mono<Person> create(@Valid @RequestBody PersonRequest request) {
        return service.create(request);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id person identifier
     * @return person with the given id
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get person", description = "Retrieves a person by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    public Mono<Person> get(@Parameter(description = "Person ID") @PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Updates an existing person.
     *
     * @param id      person identifier
     * @param request updated data
     * @return updated person
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update person", description = "Updates an existing person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    public Mono<Person> update(@Parameter(description = "Person ID") @PathVariable UUID id,
                               @Valid @RequestBody PersonRequest request) {
        return service.update(id, request);
    }

    /**
     * Deletes a person by identifier.
     *
     * @param id person identifier
     * @return completion signal
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete person", description = "Deletes a person")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Person deleted"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    public Mono<Void> delete(@Parameter(description = "Person ID") @PathVariable UUID id) {
        return service.delete(id);
    }
}

