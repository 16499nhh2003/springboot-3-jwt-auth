package com.example.jwt3auth.controller;

import com.example.jwt3auth.Constants.Constants;
import com.example.jwt3auth.dto.ApiResponse;
import com.example.jwt3auth.dto.request.RefreshTokenRequest;
import com.example.jwt3auth.dto.request.SigninRequest;
import com.example.jwt3auth.dto.request.SignupRequest;
import com.example.jwt3auth.dto.response.RefreshTokenResponse;
import com.example.jwt3auth.dto.response.SigninResponse;
import com.example.jwt3auth.dto.response.SignupResponse;
import com.example.jwt3auth.service.AuthService;
import lombok.AccessLevel;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/auth")
public class AuthController {
    AuthService authService;
    Logger logger = Logger.getLogger(AuthController.class.getName());


    @PostMapping({"/signup", "/register"})
    public ApiResponse<SignupResponse> signUp(@RequestBody SignupRequest signupRequest) {
        logger.warning(signupRequest.toString());
        SignupResponse signupResponse = authService.signUp(signupRequest);
        return ApiResponse.<SignupResponse>builder()
                .statusCode(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(signupResponse)
                .build();
    }


     @PostMapping({"/signin", "/login"})
    public ApiResponse<SigninResponse> login(@RequestBody SigninRequest signinRequest) {
        SigninResponse signinResponse = authService.signIn(signinRequest);
        boolean authenticated = signinResponse.isAuthenticated();

        return ApiResponse.<SigninResponse>builder()
                .statusCode(authenticated
                        ? HttpStatus.OK.value()
                        : HttpStatus.BAD_REQUEST.value())
                .message(authenticated
                        ? Constants.SUCCESS : Constants.FAILED)
                .data(signinResponse)
                .build();
    }


      @PostMapping("/refresh")
    public ApiResponse<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        RefreshTokenResponse refreshTokenResponse = authService.refreshToken(refreshTokenRequest);
        boolean authenticated = refreshTokenResponse.isAuthenticated();

        return ApiResponse.<RefreshTokenResponse>builder()
                .statusCode(authenticated
                        ? HttpStatus.OK.value()
                        : HttpStatus.BAD_REQUEST.value())
                .message(authenticated
                        ? Constants.SUCCESS : Constants.FAILED)
                .data(refreshTokenResponse)
                .build();
    }

}
