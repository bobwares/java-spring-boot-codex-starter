/**
 * App: common
 * Package: com.bobwares
 * File: Application.java
 * Version: 0.1.0
 * Author: AI
 * Date: 2025-09-04T22:11:01Z
 * Exports: Application, main
 * Description: Entry point for the Spring Boot application.
 *              main: boots the Spring context.
 */

package com.bobwares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
