/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: Person.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: Person, from, from
 * Description: Domain record representing a person with factory methods for creation and update.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Immutable person domain model.
 */
public record Person(
        UUID id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("zip") String zip
) {
    /**
     * Creates a new {@link Person} from the provided {@link PersonRequest} generating a new identifier.
     *
     * @param request incoming person data
     * @return newly created person
     */
    public static Person from(PersonRequest request) {
        return new Person(UUID.randomUUID(), request.firstName(), request.lastName(),
                request.city(), request.state(), request.zip());
    }

    /**
     * Creates a {@link Person} with the supplied identifier from the provided {@link PersonRequest}.
     *
     * @param id      existing identifier
     * @param request incoming person data
     * @return person instance with preserved identifier
     */
    public static Person from(UUID id, PersonRequest request) {
        return new Person(id, request.firstName(), request.lastName(),
                request.city(), request.state(), request.zip());
    }
}
