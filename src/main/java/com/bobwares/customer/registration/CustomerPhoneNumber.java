/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerPhoneNumber.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerPhoneNumber
 * Description: JPA entity for customer phone numbers.
 */

package com.bobwares.customer.registration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer_phone_number",
       uniqueConstraints = @UniqueConstraint(columnNames = {"customer_id", "number"}))
@Getter
@Setter
public class CustomerPhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "type", nullable = false, length = 20)
    @NotBlank
    @Size(max = 20)
    private String type;

    @Column(name = "number", nullable = false, length = 15)
    @NotBlank
    @Size(max = 15)
    private String number;
}
