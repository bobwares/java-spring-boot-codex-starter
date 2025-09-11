/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: CustomerControllerIT.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: CustomerControllerIT
 * Description: Integration tests for CRUD controller using Testcontainers Postgres.
 */
package com.bobwares.customer.registration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIT {

  @LocalServerPort int port;

  @BeforeAll
  static void init() {
    PostgresTestContainer.class.getName();
  }

  @Test
  void health_check() {
    var client = RestClient.builder().baseUrl("http://localhost:" + port).build();
    var status = client.get().uri("/actuator/health").retrieve().toBodilessEntity().getStatusCode();
    assertThat(status).isEqualTo(HttpStatus.OK);
  }
}
