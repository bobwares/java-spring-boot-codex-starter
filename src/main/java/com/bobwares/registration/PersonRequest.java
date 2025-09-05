/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonRequest.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonRequest
 * Description: DTO carrying incoming person data with validation constraints.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Immutable request payload for person operations.
 */
public record PersonRequest(
        @JsonProperty("first_name") @NotBlank String firstName,
        @JsonProperty("last_name") @NotBlank String lastName,
        @JsonProperty("city") @NotBlank String city,
        @JsonProperty("state") @NotBlank @Size(min = 2, max = 2) String state,
        @JsonProperty("zip") @NotBlank @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$") String zip
) {
}
