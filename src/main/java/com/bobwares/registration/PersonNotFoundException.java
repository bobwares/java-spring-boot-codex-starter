/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonNotFoundException.java
 * Version: 0.1.0
 * Turns: 1
 * Author: AI
 * Date: 2025-09-06T02:28:22Z
 * Exports: PersonNotFoundException
 * Description: Exception thrown when a person cannot be found in the in-memory store.
 */
package com.bobwares.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Signals that a person with the provided identifier does not exist.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    /**
     * Constructs the exception with a descriptive message for the missing identifier.
     *
     * @param id identifier that was not found
     */
    public PersonNotFoundException(UUID id) {
        super("Person %s not found".formatted(id));
    }
}

