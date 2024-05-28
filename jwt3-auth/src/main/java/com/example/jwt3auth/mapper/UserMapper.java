package com.example.jwt3auth.mapper;

import com.example.jwt3auth.dto.response.SignupResponse;
import com.example.jwt3auth.entity.User;
import com.example.jwt3auth.security.UserDetail;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    SignupResponse toSignupResponse(User user);
    UserDetail userToUserDetail(User user);
}
