/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerRepository.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerRepository
 * Description: Spring Data repository for Customer entities.
 */

package com.bobwares.customer.registration;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByEmailsEmail(String email);
}
