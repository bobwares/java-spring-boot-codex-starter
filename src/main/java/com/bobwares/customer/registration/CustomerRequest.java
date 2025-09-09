/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerRequest.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerRequest
 * Description: DTO for customer creation and updates.
 */
package com.bobwares.customer.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record CustomerRequest(
        @NotBlank @JsonProperty("first_name") String firstName,
        @JsonProperty("middle_name") String middleName,
        @NotBlank @JsonProperty("last_name") String lastName,
        @NotNull @Size(min = 1) @JsonProperty("emails") List<@Email String> emails,
        @NotNull @Size(min = 1) @JsonProperty("phone_numbers") List<@Valid PhoneNumber> phoneNumbers,
        @NotNull @Valid @JsonProperty("address") PostalAddress address,
        @NotNull @Valid @JsonProperty("privacy_settings") PrivacySettings privacySettings
) {}
