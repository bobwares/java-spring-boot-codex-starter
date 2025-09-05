/**
 * App: common
 * Package: com.bobwares.registration
 * File: RegistrationApplication.java
 * Version: 0.1.0
 * Turns: 3
 * Author: AI
 * Date: 2025-09-05T18:22:48Z
 * Exports: RegistrationApplication
 * Description: Entry point for the Spring Boot application and enables asynchronous processing.
 */
package com.bobwares.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Bootstraps the Spring Boot application.
 */
@SpringBootApplication
@EnableAsync
public class RegistrationApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args runtime arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}

