/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: CustomerService.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: CustomerService
 * Description: Service layer for Customer CRUD operations.
 */
package com.bobwares.customer.registration;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository repository;

  public Customer create(Customer customer) {
    if (repository.existsById(customer.getId())) {
      throw new IllegalArgumentException("Customer already exists");
    }
    return repository.save(customer);
  }

  public Customer get(UUID id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
  }

  public List<Customer> list() {
    return repository.findAll();
  }

  public Customer update(UUID id, Customer customer) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Customer not found");
    }
    customer.setId(id);
    return repository.save(customer);
  }

  public void delete(UUID id) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Customer not found");
    }
    repository.deleteById(id);
  }
}
