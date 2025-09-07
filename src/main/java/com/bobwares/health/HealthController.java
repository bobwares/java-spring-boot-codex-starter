/**
 * App: common
 * Package: com.bobwares.common.health
 * File: HealthController.java
 * Version: 0.1.0
 * Author: AI
 * Date: 2025-09-04T22:11:01Z
 * Exports: HealthController, health
 * Description: REST controller exposing the health status of the service.
 *              health: returns a constant UP status map.
 */

package com.bobwares.health;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
