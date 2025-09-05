/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonServiceTests.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonServiceTests
 * Description: Unit tests verifying the reactive CRUD operations of {@link PersonService} using Reactor
 *              utilities.
 */
package com.bobwares.registration;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Validates {@link PersonService} behavior.
 */
public class PersonServiceTests {

    /**
     * Exercises create, update, delete lifecycle and ensures retrieval after deletion fails.
     */
    @Test
    void createGetUpdateDeleteFlow() {
        PersonService service = new PersonService();
        PersonRequest request = new PersonRequest("John", "Doe", "Boston", "MA", "02115");

        Person created = service.create(request).block();
        assertNotNull(created);
        assertEquals("John", created.firstName());

        PersonRequest update = new PersonRequest("Jane", "Doe", "Cambridge", "MA", "02139");
        Person updated = service.update(created.id(), update).block();
        assertEquals("Jane", updated.firstName());

        service.delete(created.id()).block();

        StepVerifier.create(service.get(created.id()))
                .expectError(PersonNotFoundException.class)
                .verify();
    }
}
