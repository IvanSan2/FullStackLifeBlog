package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;
import com.ivansan.blogfinalproject.dto.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    UserResponseDTO register(UserRequestDTO user);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

}
