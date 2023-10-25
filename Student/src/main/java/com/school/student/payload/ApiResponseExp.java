package com.school.student.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseExp {
    private String message;
    private boolean success;
    private HttpStatus status;
}
