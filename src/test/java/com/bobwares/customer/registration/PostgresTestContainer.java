/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: PostgresTestContainer.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: PostgresTestContainer
 * Description: Singleton Postgres container for integration tests.
 */
package com.bobwares.customer.registration;

import org.testcontainers.containers.PostgreSQLContainer;

public final class PostgresTestContainer {
  private static final PostgreSQLContainer<?> POSTGRES =
      new PostgreSQLContainer<>("postgres:16-alpine")
          .withDatabaseName("app")
          .withUsername("admin")
          .withPassword("abc123");

  static {
    POSTGRES.start();
    System.setProperty("spring.datasource.url", POSTGRES.getJdbcUrl());
    System.setProperty("spring.datasource.username", POSTGRES.getUsername());
    System.setProperty("spring.datasource.password", POSTGRES.getPassword());
  }

  private PostgresTestContainer() {}
}
