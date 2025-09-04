/**
 * App: common
 * Package: com.bobwares.common.health
 * File: HealthControllerTest.java
 * Version: 0.1.0
 * Author: AI
 * Date: 2025-09-04T22:11:01Z
 * Exports: HealthControllerTest, healthEndpointReturnsStatusUp
 * Description: Integration tests for the HealthController.
 *              healthEndpointReturnsStatusUp: verifies /health returns UP.
 */

package com.bobwares.common.health;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class HealthControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void healthEndpointReturnsStatusUp() {
        webTestClient.get().uri("/health")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.status").isEqualTo("UP");
    }
}
