/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: Person.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: Person
 * Description: Domain record representing a person with utility factory methods for creation and updates.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

/**
 * Represents a person in the system. Includes static factory methods to create new
 * instances or update existing ones based on {@link PersonRequest} payloads.
 */
@Schema(name = "Person", description = "Person resource")
public record Person(
        @Schema(description = "Unique identifier", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("id")
        UUID id,

        @Schema(description = "Given name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("first_name")
        String firstName,

        @Schema(description = "Family name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("last_name")
        String lastName,

        @Schema(description = "City", example = "Metropolis", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("city")
        String city,

        @Schema(description = "Two-letter state abbreviation", example = "CA", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("state")
        String state,

        @Schema(description = "US ZIP code", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("zip")
        String zip
) {
    /**
     * Creates a new {@link Person} from the supplied request and assigns a new UUID.
     *
     * @param request valid person request
     * @return new person instance with generated identifier
     */
    public static Person from(PersonRequest request) {
        return from(UUID.randomUUID(), request);
    }

    /**
     * Creates a {@link Person} using the provided identifier and request fields.
     *
     * @param id      existing person identifier
     * @param request valid person request
     * @return person instance with supplied identifier
     */
    public static Person from(UUID id, PersonRequest request) {
        return new Person(id, request.firstName(), request.lastName(), request.city(), request.state(), request.zip());
    }
}

