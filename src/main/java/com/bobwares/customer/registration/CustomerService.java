/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerService.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerService
 * Description: Provides transactional CRUD operations for customers.
 */

package com.bobwares.customer.registration;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Customer create(Customer customer) {
        for (CustomerEmail email : customer.getEmails()) {
            if (repository.existsByEmailsEmail(email.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
            email.setCustomer(customer);
        }
        for (CustomerPhoneNumber phone : customer.getPhoneNumbers()) {
            phone.setCustomer(customer);
        }
        return repository.save(customer);
    }

    public Customer get(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public List<Customer> list() {
        return repository.findAll();
    }

    @Transactional
    public Customer update(UUID id, Customer updated) {
        Customer existing = get(id);
        existing.setFirstName(updated.getFirstName());
        existing.setMiddleName(updated.getMiddleName());
        existing.setLastName(updated.getLastName());
        existing.setAddress(updated.getAddress());
        existing.setPrivacySettings(updated.getPrivacySettings());
        existing.getEmails().clear();
        for (CustomerEmail email : updated.getEmails()) {
            email.setCustomer(existing);
            existing.getEmails().add(email);
        }
        existing.getPhoneNumbers().clear();
        for (CustomerPhoneNumber phone : updated.getPhoneNumbers()) {
            phone.setCustomer(existing);
            existing.getPhoneNumbers().add(phone);
        }
        return repository.save(existing);
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
