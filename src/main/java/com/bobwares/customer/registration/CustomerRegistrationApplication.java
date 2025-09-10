/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration
 * File: CustomerRegistrationApplication.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerRegistrationApplication, main
 * Description: Entry point for the Customer Registration Spring Boot application.
 */

package com.bobwares.customer.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bobwares")
public class CustomerRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerRegistrationApplication.class, args);
    }
}
