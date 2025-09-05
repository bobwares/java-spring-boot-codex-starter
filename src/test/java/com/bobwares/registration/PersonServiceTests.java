/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonServiceTests.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonServiceTests
 * Description: Unit tests validating PersonService create, get, update, and delete operations.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link PersonService}.
 */
class PersonServiceTests {

    @Test
    void createGetUpdateDeleteFlow() {
        PersonService service = new PersonService();
        PersonRequest req = new PersonRequest("John", "Doe", "Springfield", "IL", "62704");

        Person created = service.create(req).block();
        assertNotNull(created);
        assertNotNull(created.id());

        Person fetched = service.get(created.id()).block();
        assertEquals("John", fetched.firstName());

        PersonRequest updateReq = new PersonRequest("Jane", "Doe", "Springfield", "IL", "62704");
        Person updated = service.update(created.id(), updateReq).block();
        assertEquals("Jane", updated.firstName());

        service.delete(created.id()).block();
        StepVerifier.create(service.get(created.id()))
                .expectError(PersonNotFoundException.class)
                .verify();
    }
}
