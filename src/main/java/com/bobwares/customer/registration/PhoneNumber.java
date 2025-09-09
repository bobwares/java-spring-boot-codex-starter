/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: PhoneNumber.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: PhoneNumber
 * Description: Value object representing a phone number.
 */
package com.bobwares.customer.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PhoneNumber(
        @NotBlank @JsonProperty("type") String type,
        @NotBlank @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$") @JsonProperty("number") String number
) {}
