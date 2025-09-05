/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonController.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonController
 * Description: Reactive REST controller exposing CRUD endpoints for {@link Person} resources with OpenAPI
 *              documentation and input validation.
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.UUID;

/**
 * Handles HTTP requests for person lifecycle operations.
 */
@RestController
@RequestMapping("/api/persons")
@Tag(name = "Persons", description = "Asynchronous CRUD for persons")
@Validated
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
     * @param request validated request payload
     * @return created person
     */
    @Operation(summary = "Create person", description = "Creates a new person and returns it")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Person created", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> create(@Valid @RequestBody PersonRequest request) {
        return service.create(request);
    }

    /**
     * Retrieves a person by identifier.
     *
     * @param id unique identifier
     * @return found person
     */
    @Operation(summary = "Get person", description = "Retrieves a person by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
    })
    @GetMapping("/{id}")
    public Mono<Person> get(@Parameter(description = "Person identifier") @PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Updates an existing person.
     *
     * @param id identifier of the person
     * @param request validated request payload
     * @return updated person
     */
    @Operation(summary = "Update person", description = "Updates an existing person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person updated", content = @Content(schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content)
    })
    @PutMapping("/{id}")
    public Mono<Person> update(
            @Parameter(description = "Person identifier") @PathVariable UUID id,
            @Valid @RequestBody PersonRequest request) {
        return service.update(id, request);
    }

    /**
     * Deletes a person by identifier.
     *
     * @param id identifier of the person
     * @return completion signal
     */
    @Operation(summary = "Delete person", description = "Deletes a person by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Person deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@Parameter(description = "Person identifier") @PathVariable UUID id) {
        return service.delete(id);
    }
}
