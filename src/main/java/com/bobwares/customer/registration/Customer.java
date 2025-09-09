/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: Customer.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: Customer
 * Description: Domain model representing a customer.
 */
package com.bobwares.customer.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;

public record Customer(
        @JsonProperty("id") UUID id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("middle_name") String middleName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("emails") List<String> emails,
        @JsonProperty("phone_numbers") List<PhoneNumber> phoneNumbers,
        @JsonProperty("address") PostalAddress address,
        @JsonProperty("privacy_settings") PrivacySettings privacySettings
) {
    public static Customer from(UUID id, CustomerRequest request) {
        return new Customer(id,
                request.firstName(),
                request.middleName(),
                request.lastName(),
                request.emails(),
                request.phoneNumbers(),
                request.address(),
                request.privacySettings());
    }
}
