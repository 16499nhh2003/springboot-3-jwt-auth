package com.example.jwt3auth.service;

import com.example.jwt3auth.dto.request.RefreshTokenRequest;
import com.example.jwt3auth.dto.request.SigninRequest;
import com.example.jwt3auth.dto.request.SignupRequest;
import com.example.jwt3auth.dto.response.RefreshTokenResponse;
import com.example.jwt3auth.dto.response.SigninResponse;
import com.example.jwt3auth.dto.response.SignupResponse;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {

    SigninResponse signIn(SigninRequest signinRequest);

    SignupResponse signUp(SignupRequest signupRequest);

    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
