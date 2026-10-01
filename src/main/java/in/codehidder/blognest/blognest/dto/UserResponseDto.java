package in.codehidder.blognest.blognest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String about;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
