/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: Person.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: Person
 * Description: Domain record representing a person with identity and address attributes. Provides factory
 *              methods for creation and updating based on a {@link PersonRequest}.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * Immutable person domain object.
 *
 * @param id unique identifier
 * @param firstName given name
 * @param lastName family name
 * @param city city of residence
 * @param state two-letter state abbreviation
 * @param zip postal code
 */
public record Person(
        UUID id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        String city,
        String state,
        String zip) {

    /**
     * Creates a new {@link Person} from a request generating a new identifier.
     *
     * @param request validated request payload
     * @return newly created person
     */
    public static Person from(PersonRequest request) {
        return new Person(UUID.randomUUID(), request.firstName(), request.lastName(), request.city(), request.state(), request.zip());
    }

    /**
     * Creates a {@link Person} using an existing identifier and request data.
     *
     * @param id existing identifier
     * @param request validated request payload
     * @return updated person representation
     */
    public static Person from(UUID id, PersonRequest request) {
        return new Person(id, request.firstName(), request.lastName(), request.city(), request.state(), request.zip());
    }
}
