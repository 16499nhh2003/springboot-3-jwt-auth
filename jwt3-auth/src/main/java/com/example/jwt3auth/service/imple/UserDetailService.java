package com.example.jwt3auth.service.imple;

import com.example.jwt3auth.entity.User;
import com.example.jwt3auth.exception.EnumConfig.ErrorCode;
import com.example.jwt3auth.exception.payload.AppException;
import com.example.jwt3auth.mapper.UserMapper;
import com.example.jwt3auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.userToUserDetail( userRepository.findByEmail(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITSTED))
        );
    }

}