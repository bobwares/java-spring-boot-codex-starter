/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration.persistence
 * File: PrivacySettingsEntity.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: PrivacySettingsEntity
 * Description: JPA entity representing privacy settings.
 */
package com.bobwares.customer.registration.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "privacy_settings")
public class PrivacySettingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer privacySettingsId;
    private boolean marketingEmailsEnabled;
    private boolean twoFactorEnabled;

    // getters and setters
    public Integer getPrivacySettingsId() {
        return privacySettingsId;
    }

    public void setPrivacySettingsId(Integer privacySettingsId) {
        this.privacySettingsId = privacySettingsId;
    }

    public boolean isMarketingEmailsEnabled() {
        return marketingEmailsEnabled;
    }

    public void setMarketingEmailsEnabled(boolean marketingEmailsEnabled) {
        this.marketingEmailsEnabled = marketingEmailsEnabled;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }
}
