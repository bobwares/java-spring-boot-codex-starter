/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration.api
 * File: CustomerDto.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerDto, CreateRequest, UpdateRequest, Response, Address, Privacy, PhoneNumber
 * Description: Data transfer objects for Customer API.
 */

package com.bobwares.customer.registration.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
import lombok.Data;

public class CustomerDto {
    @Data
    public static class Address {
        @NotBlank
        private String line1;
        private String line2;
        @NotBlank
        private String city;
        @NotBlank
        private String state;
        private String postalCode;
        @NotBlank
        @Size(min = 2, max = 2)
        private String country;
    }

    @Data
    public static class Privacy {
        @NotNull
        private Boolean marketingEmailsEnabled;
        @NotNull
        private Boolean twoFactorEnabled;
    }

    @Data
    public static class PhoneNumber {
        @NotBlank
        private String type;
        @NotBlank
        private String number;
    }

    @Data
    public static class CreateRequest {
        @NotBlank
        private String firstName;
        private String middleName;
        @NotBlank
        private String lastName;
        @NotNull
        @Size(min = 1)
        private List<@Email String> emails;
        @NotNull
        private Address address;
        @NotNull
        private Privacy privacySettings;
        @NotNull
        @Size(min = 1)
        private List<@NotNull PhoneNumber> phoneNumbers;
    }

    @Data
    public static class UpdateRequest extends CreateRequest { }

    @Data
    public static class Response {
        private UUID id;
        private String firstName;
        private String middleName;
        private String lastName;
        private List<String> emails;
        private Address address;
        private Privacy privacySettings;
        private List<PhoneNumber> phoneNumbers;
    }
}
