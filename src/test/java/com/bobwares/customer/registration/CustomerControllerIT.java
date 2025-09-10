/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerControllerIT.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerControllerIT
 * Description: Integration tests for Customer REST controller.
 */

package com.bobwares.customer.registration;

import static org.assertj.core.api.Assertions.assertThat;

import com.bobwares.customer.registration.api.CustomerDto;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIT {
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
    TestRestTemplate restTemplate;

    @Test
    void customerCrudFlow() {
        CustomerDto.CreateRequest req = new CustomerDto.CreateRequest();
        req.setFirstName("Bob");
        req.setLastName("Jones");
        CustomerDto.Address addr = new CustomerDto.Address();
        addr.setLine1("100 Main St");
        addr.setCity("City");
        addr.setState("ST");
        addr.setCountry("US");
        req.setAddress(addr);
        CustomerDto.Privacy privacy = new CustomerDto.Privacy();
        privacy.setMarketingEmailsEnabled(true);
        privacy.setTwoFactorEnabled(false);
        req.setPrivacySettings(privacy);
        CustomerDto.PhoneNumber phone = new CustomerDto.PhoneNumber();
        phone.setType("mobile");
        phone.setNumber("+15550000002");
        req.setPhoneNumbers(List.of(phone));
        req.setEmails(List.of("bob@example.com"));

        ResponseEntity<CustomerDto.Response> create = restTemplate.postForEntity("/api/customers", req, CustomerDto.Response.class);
        assertThat(create.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        UUID id = create.getBody().getId();

        ResponseEntity<CustomerDto.Response> get = restTemplate.getForEntity("/api/customers/" + id, CustomerDto.Response.class);
        assertThat(get.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(get.getBody().getFirstName()).isEqualTo("Bob");

        restTemplate.delete("/api/customers/" + id);
        ResponseEntity<String> afterDelete = restTemplate.getForEntity("/api/customers/" + id, String.class);
        assertThat(afterDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
