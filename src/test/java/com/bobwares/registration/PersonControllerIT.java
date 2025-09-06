/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonControllerIT.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonControllerIT
 * Description: Integration tests exercising the Person REST endpoints using WebTestClient.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

/**
 * Verifies that the {@link PersonController} exposes a functioning CRUD API.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class PersonControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void fullCrudLifecycle() {
        PersonRequest request = new PersonRequest("John", "Doe", "Metropolis", "CA", "12345");
        Person created = webTestClient.post()
                .uri("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody();

        UUID id = created.id();

        webTestClient.get()
                .uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("John");

        PersonRequest update = new PersonRequest("Jane", "Doe", "Gotham", "CA", "12345");
        webTestClient.put()
                .uri("/api/persons/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(update)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("Jane");

        webTestClient.delete()
                .uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        webTestClient.get()
                .uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void invalidPayloadReturns400() {
        PersonRequest bad = new PersonRequest("", "", "Metropolis", "C", "abc");
        webTestClient.post()
                .uri("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(bad)
                .exchange()
                .expectStatus().isBadRequest();
    }
}

