/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerServiceTests.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerServiceTests
 * Description: Unit tests for CustomerService.
 */

package com.bobwares.customer.registration;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class CustomerServiceTests {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void configure(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Autowired
    CustomerService service;

    @Test
    void createAndFetchCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Smith");

        PostalAddress addr = new PostalAddress();
        addr.setLine1("100 Main St");
        addr.setCity("City");
        addr.setState("ST");
        addr.setCountry("US");
        customer.setAddress(addr);

        PrivacySettings ps = new PrivacySettings();
        ps.setMarketingEmailsEnabled(true);
        ps.setTwoFactorEnabled(false);
        customer.setPrivacySettings(ps);

        CustomerEmail email = new CustomerEmail();
        email.setEmail("alice@example.com");
        customer.getEmails().add(email);

        CustomerPhoneNumber phone = new CustomerPhoneNumber();
        phone.setType("mobile");
        phone.setNumber("+15550000001");
        customer.getPhoneNumbers().add(phone);

        Customer saved = service.create(customer);
        Customer found = service.get(saved.getCustomerId());
        assertThat(found.getFirstName()).isEqualTo("Alice");
        assertThat(found.getEmails()).hasSize(1);
        service.delete(saved.getCustomerId());
        assertThat(service.list()).isEmpty();
    }
}
