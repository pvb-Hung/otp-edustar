package com.example.ttcn2etest.request.auth;

import com.example.ttcn2etest.validator.EmailAnnotation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegenerateOtpRequest {
    @NotBlank(message = "Email không được để trống!")
    @EmailAnnotation
    private String email;
}
