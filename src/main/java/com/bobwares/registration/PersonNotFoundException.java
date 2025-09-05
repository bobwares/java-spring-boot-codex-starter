/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: PersonNotFoundException.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: PersonNotFoundException
 * Description: Exception thrown when a requested person cannot be located in the persistence store.
 */
package com.bobwares.registration;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Indicates the requested person does not exist.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

    /**
     * Creates a new exception with a descriptive message for the missing identifier.
     *
     * @param id identifier that could not be found
     */
    public PersonNotFoundException(UUID id) {
        super("Person with id " + id + " not found");
    }
}
