/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerServiceImpl.java
 * Version: 0.1.0
 * Turns: 2
 * Author: Codex
 * Date: 2025-09-09T22:44:34Z
 * Exports: CustomerServiceImpl
 * Description: In-memory implementation of CustomerService.
 */
package com.bobwares.customer.registration;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, Customer> store = new ConcurrentHashMap<>();

    @Override
    public Mono<Customer> create(CustomerRequest request) {
        UUID id = UUID.randomUUID();
        Customer customer = Customer.from(id, request);
        store.put(id, customer);
        return Mono.just(customer);
    }

    @Override
    public Mono<Customer> get(UUID id) {
        Customer customer = store.get(id);
        if (customer == null) {
            return Mono.error(new CustomerNotFoundException(id));
        }
        return Mono.just(customer);
    }

    @Override
    public Mono<Customer> update(UUID id, CustomerRequest request) {
        if (!store.containsKey(id)) {
            return Mono.error(new CustomerNotFoundException(id));
        }
        Customer customer = Customer.from(id, request);
        store.put(id, customer);
        return Mono.just(customer);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        if (store.remove(id) == null) {
            return Mono.error(new CustomerNotFoundException(id));
        }
        return Mono.empty();
    }
}
