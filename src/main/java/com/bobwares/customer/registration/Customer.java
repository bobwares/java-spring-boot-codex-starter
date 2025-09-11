/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: Customer.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: Customer
 * Description: JPA entity representing a customer aggregate.
 */

package com.bobwares.customer.registration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "first_name", nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String firstName;

    @Column(name = "middle_name", length = 255)
    @Size(max = 255)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private PostalAddress address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "privacy_settings_id")
    private PrivacySettings privacySettings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerEmail> emails = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerPhoneNumber> phoneNumbers = new ArrayList<>();
}
