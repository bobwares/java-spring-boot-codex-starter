/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerServiceTest.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerServiceTest
 * Description: Unit tests for CustomerService.
 */
package com.bobwares.customer.registration;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class CustomerServiceTest {

    private final CustomerService service = new CustomerServiceImpl();

    private CustomerRequest sampleRequest() {
        return new CustomerRequest(
                "Alice",
                null,
                "Smith",
                List.of("alice@example.com"),
                List.of(new PhoneNumber("mobile", "+15555550101")),
                new PostalAddress("100 Market St", null, "Springfield", "IL", "62701", "US"),
                new PrivacySettings(true, true)
        );
    }

    @Test
    void createAndGet() {
        StepVerifier.create(service.create(sampleRequest()).flatMap(c -> service.get(c.id())))
                .assertNext(c -> {
                    assert c.firstName().equals("Alice");
                })
                .verifyComplete();
    }

    @Test
    void updateAndDelete() {
        CustomerRequest request = sampleRequest();
        UUID id = service.create(request).block().id();
        CustomerRequest updated = new CustomerRequest(
                "Bob",
                null,
                "Jones",
                List.of("bob@example.com"),
                List.of(new PhoneNumber("mobile", "+15555550102")),
                request.address(),
                request.privacySettings()
        );

        StepVerifier.create(service.update(id, updated))
                .assertNext(c -> {
                    assert c.firstName().equals("Bob");
                })
                .verifyComplete();

        StepVerifier.create(service.delete(id)).verifyComplete();
        StepVerifier.create(service.get(id)).expectError(CustomerNotFoundException.class).verify();
    }
}
