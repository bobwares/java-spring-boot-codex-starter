/**
 * App: java-spring-boot-codex-starter
 * Package: com.bobwares.registration
 * File: RegistrationApplication.java
 * Version: 0.1.0
 * Turns: 1
 * Author: Codex Agent
 * Date: 2025-09-05T19:46:19Z
 * Exports: RegistrationApplication
 * Description: Boots the Spring Boot WebFlux application and provides the main entry point.
 */
package com.bobwares.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the WebFlux registration service.
 */
@SpringBootApplication
public class RegistrationApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}
