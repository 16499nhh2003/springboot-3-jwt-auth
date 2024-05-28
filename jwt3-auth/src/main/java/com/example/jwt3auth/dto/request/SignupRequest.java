package com.example.jwt3auth.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequest {
    String name;
    String email;
    String password;
    Set<String> role;
}

