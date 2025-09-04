/**
 * App: common
 * Package: com.bobwares.common.person
 * File: PersonControllerTest.java
 * Version: 0.1.0
 * Turn #: 1
 * Author: AI
 * Date: 2025-09-04T23:36:46Z
 * Exports: PersonControllerTest, personCrudFlow
 * Description: Integration tests for PersonController verifying asynchronous CRUD operations.
 *              personCrudFlow: ensures put, get, update, and delete endpoints function.
 */

package com.bobwares.common.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class PersonControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void personCrudFlow() {
        Person person = new Person("John", "Doe", "City", "ST", "12345");
        Person updated = new Person("Jane", "Doe", "Town", "ST", "12345");

        webTestClient.put().uri("/person/1")
            .bodyValue(person)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.first_name").isEqualTo("John");

        webTestClient.get().uri("/person/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.city").isEqualTo("City");

        webTestClient.post().uri("/person/1")
            .bodyValue(updated)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.first_name").isEqualTo("Jane");

        webTestClient.delete().uri("/person/1")
            .exchange()
            .expectStatus().isOk();

        webTestClient.get().uri("/person/1")
            .exchange()
            .expectStatus().isNotFound();
    }
}
