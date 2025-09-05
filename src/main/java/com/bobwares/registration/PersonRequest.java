/**
 * App: common
 * Package: com.bobwares.registration
 * File: PersonRequest.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: PersonRequest
 * Description: Data transfer object representing a request to create or update a person.
 */
package com.bobwares.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Represents a person creation or update request.
 * Fields mirror the person.schema.json definition.
 *
 * @param firstName person's first name
 * @param lastName  person's last name
 * @param city      city of residence
 * @param state     two-letter state abbreviation
 * @param zip       ZIP code or ZIP+4
 */
public record PersonRequest(
        @JsonProperty("first_name")
        @NotBlank(message = "first_name is required") String firstName,
        @JsonProperty("last_name")
        @NotBlank(message = "last_name is required") String lastName,
        @JsonProperty("city")
        @NotBlank(message = "city is required") String city,
        @JsonProperty("state")
        @NotBlank(message = "state is required")
        @Size(min = 2, max = 2, message = "state must be two letters") String state,
        @JsonProperty("zip")
        @NotBlank(message = "zip is required")
        @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "zip must be 5 digits or ZIP+4") String zip
) { }

