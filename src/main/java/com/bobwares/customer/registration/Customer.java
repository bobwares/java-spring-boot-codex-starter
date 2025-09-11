/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: Customer.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: Customer
 * Description: JPA entity representing a customer profile with emails and privacy settings.
 */
package com.bobwares.customer.registration;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @Column(name = "customer_id")
  private UUID id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "customer_email", joinColumns = @JoinColumn(name = "customer_id"))
  @Column(name = "email", nullable = false)
  private Set<String> emails = new HashSet<>();

  @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
  @JoinColumn(name = "privacy_settings_id")
  private PrivacySettings privacySettings;
}
