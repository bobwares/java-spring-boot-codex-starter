/**
 * App: common
 * Package: com.bobwares.registration
 * File: Person.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: Person
 * Description: Domain object representing a registered person with a unique identifier.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * Domain object representing a person.
 */
public record Person(
        @JsonProperty("id") UUID id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("zip") String zip
) {
    /**
     * Creates a {@link Person} from a {@link PersonRequest} generating a new identifier.
     *
     * @param request request data
     * @return a new person
     */
    public static Person from(PersonRequest request) {
        return new Person(UUID.randomUUID(), request.firstName(), request.lastName(), request.city(), request.state(), request.zip());
    }

    /**
     * Creates an updated {@link Person} with a specific identifier.
     *
     * @param id      existing identifier
     * @param request request data
     * @return updated person
     */
    public static Person from(UUID id, PersonRequest request) {
        return new Person(id, request.firstName(), request.lastName(), request.city(), request.state(), request.zip());
    }
}

