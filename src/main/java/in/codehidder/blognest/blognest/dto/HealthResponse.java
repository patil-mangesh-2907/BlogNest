package in.codehidder.blognest.blognest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponse {
    private String appStatus;
    private String dbStatus;
    private LocalDateTime timestamp;
}
