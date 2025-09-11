/**
 * App: registration
 * Package: com.bobwares.customer.registration.api
 * File: CustomerController.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: CustomerController
 * Description: REST controller providing CRUD operations for Customer.
 */
package com.bobwares.customer.registration.api;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bobwares.customer.registration.Customer;
import com.bobwares.customer.registration.CustomerService;
import com.bobwares.customer.registration.PrivacySettings;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService service;

  @PostMapping
  public ResponseEntity<CustomerDto> create(@Valid @RequestBody CustomerDto dto) {
    Customer saved = service.create(toEntity(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(toDto(saved));
  }

  @GetMapping("/{id}")
  public CustomerDto get(@PathVariable UUID id) {
    return toDto(service.get(id));
  }

  @GetMapping
  public List<CustomerDto> list() {
    return service.list().stream().map(this::toDto).toList();
  }

  @PutMapping("/{id}")
  public CustomerDto update(@PathVariable UUID id, @Valid @RequestBody CustomerDto dto) {
    return toDto(service.update(id, toEntity(dto)));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    service.delete(id);
  }

  private CustomerDto toDto(Customer customer) {
    var ps = customer.getPrivacySettings();
    return new CustomerDto(
        customer.getId(),
        customer.getFirstName(),
        customer.getMiddleName(),
        customer.getLastName(),
        customer.getEmails().stream().toList(),
        new CustomerDto.PrivacySettingsDto(ps.isMarketingEmailsEnabled(), ps.isTwoFactorEnabled()));
  }

  private Customer toEntity(CustomerDto dto) {
    PrivacySettings ps = new PrivacySettings(null, dto.privacySettings().marketingEmailsEnabled(), dto.privacySettings().twoFactorEnabled());
    return new Customer(
        dto.id() == null ? UUID.randomUUID() : dto.id(),
        dto.firstName(),
        dto.middleName(),
        dto.lastName(),
        new java.util.HashSet<>(dto.emails()),
        ps);
  }
}
