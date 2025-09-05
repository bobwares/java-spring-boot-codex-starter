/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonController.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonController
 * Description: WebFlux controller exposing asynchronous CRUD endpoints for persons.
 */
package com.bobwares.registration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * REST controller for managing {@link Person} resources.
 */
@RestController
@RequestMapping("/api/persons")
@Validated
@Tag(name = "Persons", description = "Asynchronous CRUD for persons")
public class PersonController {
    private final PersonService service;

    /**
     * Constructs the controller with required dependencies.
     *
     * @param service person service
     */
    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * Creates a new person.
     *
     * @param request person payload
     * @return persisted person
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create person", description = "Creates a new person")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Person created", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    public Mono<Person> create(@Valid @RequestBody PersonRequest request) {
        return service.create(request);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id person identifier
     * @return person
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get person", description = "Fetches a person by identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
    })
    public Mono<Person> get(@Parameter(description = "Person identifier") @PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Updates an existing person.
     *
     * @param id      person identifier
     * @param request update payload
     * @return updated person
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update person", description = "Updates a person by identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person updated", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
    })
    public Mono<Person> update(@Parameter(description = "Person identifier") @PathVariable UUID id,
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
    @Operation(summary = "Delete person", description = "Deletes a person by identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Person deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
    })
    public Mono<Void> delete(@Parameter(description = "Person identifier") @PathVariable UUID id) {
        return service.delete(id);
    }
}
