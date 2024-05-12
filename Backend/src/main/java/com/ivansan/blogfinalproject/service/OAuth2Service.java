package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface OAuth2Service extends UserDetailsService {

    LoginResponseDTO registerAndLogin(Authentication authentication);
}
