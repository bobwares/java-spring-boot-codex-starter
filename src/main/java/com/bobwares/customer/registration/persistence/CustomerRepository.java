/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration.persistence
 * File: CustomerRepository.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerRepository
 * Description: Spring Data repository for CustomerEntity.
 */
package com.bobwares.customer.registration.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
