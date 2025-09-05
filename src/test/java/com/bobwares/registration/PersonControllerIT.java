/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonControllerIT.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonControllerIT
 * Description: Integration tests for PersonController verifying HTTP endpoints.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Integration tests using {@link WebTestClient}.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonControllerIT {

    @LocalServerPort
    int port;

    @Autowired
    WebTestClient client;

    @Test
    void lifecycle() {
        PersonRequest req = new PersonRequest("John", "Doe", "Springfield", "IL", "62704");

        UUID id = client.post().uri("/api/persons")
                .bodyValue(req)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult().getResponseBody().id();

        client.get().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name", is("John"));

        PersonRequest updateReq = new PersonRequest("Jane", "Doe", "Springfield", "IL", "62704");
        client.put().uri("/api/persons/{id}", id)
                .bodyValue(updateReq)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name", is("Jane"));

        client.delete().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        client.get().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void validation() {
        PersonRequest bad = new PersonRequest("", "", "", "I", "123");

        client.post().uri("/api/persons")
                .bodyValue(bad)
                .exchange()
                .expectStatus().isBadRequest();
    }
}
