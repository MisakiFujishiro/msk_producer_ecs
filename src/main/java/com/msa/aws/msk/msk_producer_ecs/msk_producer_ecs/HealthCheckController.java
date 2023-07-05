package com.msa.aws.msk.msk_producer_ecs.msk_producer_ecs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthCheckController {
    @GetMapping("/msk-producer-healthCheck")
        public ResponseEntity<String> healthCheck() {
            return ResponseEntity.ok("Healthy");
    }
}
