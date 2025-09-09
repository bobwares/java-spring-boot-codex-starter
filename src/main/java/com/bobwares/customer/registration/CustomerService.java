/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerService.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerService
 * Description: Service interface for managing customers.
 */
package com.bobwares.customer.registration;

import java.util.UUID;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer> create(CustomerRequest request);
    Mono<Customer> get(UUID id);
    Mono<Customer> update(UUID id, CustomerRequest request);
    Mono<Void> delete(UUID id);
}
