/**
 * App: common
 * Package: com.bobwares.registration
 * File: PersonNotFoundException.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: PersonNotFoundException
 * Description: Exception thrown when a person is not found in the in-memory store.
 */
package com.bobwares.registration;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Signals that a person could not be located.
 */
public class PersonNotFoundException extends ResponseStatusException {

    /**
     * Creates the exception with a standard message and HTTP 404 status.
     *
     * @param id identifier that was not found
     */
    public PersonNotFoundException(UUID id) {
        super(HttpStatus.NOT_FOUND, "Person " + id + " not found");
    }
}

