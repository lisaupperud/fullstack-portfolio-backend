package com.liluppis.portfolioAPI.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        try {
            HealthCheckResponse healthOk = new HealthCheckResponse(200, "OK");
            return ResponseEntity.ok(healthOk);
        } catch (Exception ex) {
            HealthCheckResponse healthBad = new HealthCheckResponse(503, "Service Unavailable");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(healthBad);
        }
    }

    public record HealthCheckResponse(
            int status,
            String message
    ){}
}
