/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: PostalAddress.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: PostalAddress
 * Description: JPA entity representing a postal address.
 */

package com.bobwares.customer.registration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postal_address")
@Getter
@Setter
public class PostalAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "line1", nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String line1;

    @Column(name = "line2", length = 255)
    @Size(max = 255)
    private String line2;

    @Column(name = "city", nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String state;

    @Column(name = "postal_code", length = 20)
    @Size(max = 20)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 2)
    @NotBlank
    @Size(min = 2, max = 2)
    private String country;
}
