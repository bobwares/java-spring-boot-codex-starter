/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonRequest.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonRequest
 * Description: Data transfer object capturing input fields for a person with validation constraints applied
 *              to ensure data integrity.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Payload representing a person creation or update request.
 *
 * @param firstName given name
 * @param lastName family name
 * @param city city of residence
 * @param state two-letter state abbreviation
 * @param zip postal code in five-digit or ZIP+4 format
 */
public record PersonRequest(
        @JsonProperty("first_name") @NotBlank String firstName,
        @JsonProperty("last_name") @NotBlank String lastName,
        @NotBlank String city,
        @Size(min = 2, max = 2) String state,
        @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$") String zip) {
}
