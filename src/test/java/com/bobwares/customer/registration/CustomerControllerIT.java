/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerControllerIT.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerControllerIT
 * Description: Integration tests for CustomerController.
 */
package com.bobwares.customer.registration;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CustomerControllerIT {

    @Autowired
    private WebTestClient client;

    private CustomerRequest sampleRequest() {
        return new CustomerRequest(
                "Alice",
                null,
                "Smith",
                List.of("alice@example.com"),
                List.of(new PhoneNumber("mobile", "+15555550101")),
                new PostalAddress("100 Market St", null, "Springfield", "IL", "62701", "US"),
                new PrivacySettings(true, true)
        );
    }

    @Test
    void lifecycle() {
        UUID id = client.post().uri("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(sampleRequest())
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Customer.class)
                .returnResult()
                .getResponseBody()
                .id();

        client.get().uri("/api/customers/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("Alice");

        CustomerRequest updated = new CustomerRequest(
                "Bob",
                null,
                "Jones",
                List.of("bob@example.com"),
                List.of(new PhoneNumber("mobile", "+15555550102")),
                new PostalAddress("200 Oak Ave", "Apt 2", "Madison", "WI", "53703", "US"),
                new PrivacySettings(false, true)
        );

        client.put().uri("/api/customers/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(updated)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("Bob");

        client.delete().uri("/api/customers/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        client.get().uri("/api/customers/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }
}
