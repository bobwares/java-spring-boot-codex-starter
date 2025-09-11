/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: PrivacySettings.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: PrivacySettings
 * Description: JPA entity representing customer privacy preferences.
 */
package com.bobwares.customer.registration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "privacy_settings")
public class PrivacySettings {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "privacy_settings_id")
  private Long id;

  @Column(name = "marketing_emails_enabled", nullable = false)
  private boolean marketingEmailsEnabled;

  @Column(name = "two_factor_enabled", nullable = false)
  private boolean twoFactorEnabled;
}
