/**
 * App: Person CRUD Service
 * Package: com.bobwares.registration
 * File: PersonNotFoundException.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T23:11:56Z
 * Exports: PersonNotFoundException
 * Description: Exception indicating a person identifier was not found.
 */
package com.bobwares.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Signals that a person could not be located in the store.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    /**
     * Constructs the exception with the missing identifier.
     *
     * @param id missing identifier
     */
    public PersonNotFoundException(UUID id) {
        super("Person not found: " + id);
    }
}
