/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonRequest.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonRequest
 * Description: Request DTO for creating or updating a person. Validates input fields using Jakarta Bean Validation.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Represents the payload required to create or update a Person.
 * All fields are mandatory and follow snake_case naming in JSON.
 */
@Schema(name = "PersonRequest", description = "Payload to create or update a person")
public record PersonRequest(
        @Schema(description = "Given name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @JsonProperty("first_name")
        String firstName,

        @Schema(description = "Family name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @JsonProperty("last_name")
        String lastName,

        @Schema(description = "City", example = "Metropolis", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @JsonProperty("city")
        String city,

        @Schema(description = "Two-letter state abbreviation", example = "CA", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Size(min = 2, max = 2)
        @JsonProperty("state")
        String state,

        @Schema(description = "US ZIP code (5 digits or ZIP+4)", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$")
        @JsonProperty("zip")
        String zip
) {
}

