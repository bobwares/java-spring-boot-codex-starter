/**
 * App: common
 * Package: com.bobwares.registration
 * File: PersonControllerTest.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: PersonControllerTest
 * Description: Integration tests verifying the asynchronous person endpoints.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Ensures the person controller supports full CRUD lifecycle.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class PersonControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient client;

    @Test
    void createLifecycle() {
        PersonRequest request = new PersonRequest("John", "Doe", "New York", "NY", "10001");

        String id = client.post().uri("http://localhost:" + port + "/api/persons")
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody()
                .id()
                .toString();

        client.get().uri("http://localhost:" + port + "/api/persons/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(id);

        PersonRequest update = new PersonRequest("Jane", "Doe", "Los Angeles", "CA", "90001");

        client.put().uri("http://localhost:" + port + "/api/persons/{id}", id)
                .bodyValue(update)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("Jane");

        client.delete().uri("http://localhost:" + port + "/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        client.get().uri("http://localhost:" + port + "/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }
}

