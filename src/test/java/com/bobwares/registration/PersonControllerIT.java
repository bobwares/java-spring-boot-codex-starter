/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonControllerIT.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonControllerIT
 * Description: Integration tests validating the HTTP endpoints exposed by {@link PersonController} using
 *              WebTestClient against a running application context.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Exercises the REST API end-to-end.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class PersonControllerIT {

    @Autowired
    private WebTestClient client;

    /**
     * Verifies the full CRUD lifecycle through HTTP requests.
     */
    @Test
    void personLifecycle() {
        PersonRequest request = new PersonRequest("John", "Doe", "Boston", "MA", "02115");

        String id = client.post().uri("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody()
                .id()
                .toString();

        client.get().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("John");

        PersonRequest update = new PersonRequest("Jane", "Doe", "Cambridge", "MA", "02139");
        client.put().uri("/api/persons/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(update)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.first_name").isEqualTo("Jane");

        client.delete().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        client.get().uri("/api/persons/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }
}
