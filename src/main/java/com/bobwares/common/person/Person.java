/**
 * App: common
 * Package: com.bobwares.common.person
 * File: Person.java
 * Version: 0.1.0
 * Turn #: 1
 * Author: AI
 * Date: 2025-09-04T23:36:46Z
 * Exports: Person
 * Description: Data transfer object representing a person's address.
 *              Validates fields per US address constraints.
 */

package com.bobwares.common.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Person(
        @JsonProperty("first_name") @NotBlank String firstName,
        @JsonProperty("last_name") @NotBlank String lastName,
        @NotBlank String city,
        @Size(min = 2, max = 2) String state,
        @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$") String zip) {
}
