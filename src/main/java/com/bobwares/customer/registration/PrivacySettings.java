/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: PrivacySettings.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: PrivacySettings
 * Description: Value object representing privacy settings.
 */
package com.bobwares.customer.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record PrivacySettings(
        @NotNull @JsonProperty("marketing_emails_enabled") Boolean marketingEmailsEnabled,
        @NotNull @JsonProperty("two_factor_enabled") Boolean twoFactorEnabled
) {}
