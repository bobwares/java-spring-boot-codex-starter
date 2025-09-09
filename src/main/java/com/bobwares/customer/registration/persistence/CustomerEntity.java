/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration.persistence
 * File: CustomerEntity.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerEntity
 * Description: JPA entity representing a customer.
 */
package com.bobwares.customer.registration.persistence;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private UUID customerId;
    private String firstName;
    private String middleName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private PostalAddressEntity address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privacy_settings_id")
    private PrivacySettingsEntity privacySettings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerEmailEntity> emails = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerPhoneNumberEntity> phoneNumbers = new HashSet<>();

    // getters and setters
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PostalAddressEntity getAddress() {
        return address;
    }

    public void setAddress(PostalAddressEntity address) {
        this.address = address;
    }

    public PrivacySettingsEntity getPrivacySettings() {
        return privacySettings;
    }

    public void setPrivacySettings(PrivacySettingsEntity privacySettings) {
        this.privacySettings = privacySettings;
    }

    public Set<CustomerEmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(Set<CustomerEmailEntity> emails) {
        this.emails = emails;
    }

    public Set<CustomerPhoneNumberEntity> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<CustomerPhoneNumberEntity> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
