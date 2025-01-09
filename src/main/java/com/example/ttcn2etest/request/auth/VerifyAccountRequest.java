package com.example.ttcn2etest.request.auth;

import com.example.ttcn2etest.validator.EmailAnnotation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyAccountRequest {
    @NotBlank(message = "Email không được để trống!")
    @EmailAnnotation
    private String email;

    @Size(min = 6,max=15, message = "OTP không được bỏ trống")
    private String otp;
}
