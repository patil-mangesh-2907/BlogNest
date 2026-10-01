package in.codehidder.blognest.blognest.controller;

import in.codehidder.blognest.blognest.dto.HealthResponse;
import in.codehidder.blognest.blognest.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/health")
public class HealthController {
    private final HealthService healthService;

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        HealthResponse healthResponse = new HealthResponse(
                "UP",
                healthService.checkDbStatus(),
                LocalDateTime.now()
        );

        return ResponseEntity.ok(healthResponse);
    }
}
