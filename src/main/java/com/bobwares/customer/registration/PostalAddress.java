/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: PostalAddress.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: PostalAddress
 * Description: Value object representing a postal address.
 */
package com.bobwares.customer.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostalAddress(
        @NotBlank @JsonProperty("line1") String line1,
        @JsonProperty("line2") String line2,
        @NotBlank @JsonProperty("city") String city,
        @NotBlank @JsonProperty("state") String state,
        @JsonProperty("postal_code") String postalCode,
        @NotBlank @Size(min = 2, max = 2) @JsonProperty("country") String country
) {}
