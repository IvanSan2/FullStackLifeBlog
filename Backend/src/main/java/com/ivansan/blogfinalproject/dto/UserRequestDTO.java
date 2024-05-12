package com.ivansan.blogfinalproject.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@Builder
public class UserRequestDTO{
        @NonNull
        @Pattern(
                regexp = "^[a-zA-Z0-9._]{2,20}$",
                message = "username must be between 2 and 20 characters and can only contain letters, numbers, and the following characters: . _"
        )
        String username;
            @NonNull
            @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
            ,message = "password must contain at least 1 lowercase letter,1 uppercase letter,1 digit and 1 special character"
            )
        String password;
        @NonNull
        @Pattern(
                regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message = "Invalid email format."
        )
        String email;
        String image;
        String provider;
        String providerId;

  }
