/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonServiceTests.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonServiceTests
 * Description: Unit tests verifying the create, read, update, and delete operations of PersonService.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the {@link PersonService} for correct CRUD behavior and error handling.
 */
public class PersonServiceTests {

    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService();
    }

    @Test
    void createGetUpdateDeleteFlow() {
        PersonRequest request = new PersonRequest("John", "Doe", "Metropolis", "CA", "12345");
        Person created = service.create(request).block();
        assertThat(created).isNotNull();
        assertThat(created.id()).isNotNull();

        Person fetched = service.get(created.id()).block();
        assertThat(fetched.firstName()).isEqualTo("John");

        PersonRequest update = new PersonRequest("Jane", "Doe", "Gotham", "CA", "12345");
        Person updated = service.update(created.id(), update).block();
        assertThat(updated.firstName()).isEqualTo("Jane");

        service.delete(created.id()).block();
        StepVerifier.create(service.get(created.id()))
                .expectError(PersonNotFoundException.class)
                .verify();
    }

    @Test
    void deleteUnknownPersonRaisesError() {
        UUID unknownId = UUID.randomUUID();
        StepVerifier.create(service.delete(unknownId))
                .expectError(PersonNotFoundException.class)
                .verify();
    }
}

