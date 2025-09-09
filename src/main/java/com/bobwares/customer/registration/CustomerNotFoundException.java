/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerNotFoundException.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerNotFoundException
 * Description: Exception thrown when a customer is not found.
 */
package com.bobwares.customer.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(java.util.UUID id) {
        super("Customer not found: " + id);
    }
}
