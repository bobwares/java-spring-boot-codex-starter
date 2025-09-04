/**
 * App: common
 * Package: com.bobwares.common
 * File: CommonApplication.java
 * Version: 0.1.0
 * Author: AI
 * Date: 2025-09-04T22:11:01Z
 * Exports: CommonApplication, main
 * Description: Entry point for the Spring Boot application.
 *              main: boots the Spring context.
 */

package com.bobwares.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
