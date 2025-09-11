/**
 * App: registration
 * Package: com.bobwares.customer.registration.api
 * File: CustomerDto.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: CustomerDto, PrivacySettingsDto
 * Description: DTOs for Customer REST API.
 */
package com.bobwares.customer.registration.api;

import java.util.List;
import java.util.UUID;

public record CustomerDto(
    UUID id,
    String firstName,
    String middleName,
    String lastName,
    List<String> emails,
    PrivacySettingsDto privacySettings) {

  public record PrivacySettingsDto(boolean marketingEmailsEnabled, boolean twoFactorEnabled) {}
}
