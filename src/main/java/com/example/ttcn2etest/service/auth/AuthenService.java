package com.example.ttcn2etest.service.auth;

import com.example.ttcn2etest.request.auth.LoginRequest;
import com.example.ttcn2etest.request.auth.RegenerateOtpRequest;
import com.example.ttcn2etest.request.auth.RegisterRequest;
import com.example.ttcn2etest.request.auth.VerifyAccountRequest;
import com.example.ttcn2etest.response.DashBoardResponse;
import com.example.ttcn2etest.response.LoginResponse;
import jakarta.validation.Valid;

public interface AuthenService {
    LoginResponse authenticateUser(LoginRequest loginRequest);

    void registerUser(RegisterRequest signUpRequest);

    DashBoardResponse getDashBoard(int year);

    String verifyAccount(@Valid VerifyAccountRequest request);

    String regenerateOTP(@Valid RegenerateOtpRequest request);
}
