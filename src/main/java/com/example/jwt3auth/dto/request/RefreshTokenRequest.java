package com.example.jwt3auth.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefreshTokenRequest {
    String token;
}