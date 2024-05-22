package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface OAuth2Service {
    LoginResponseDTO registerAndLogin(OAuth2AuthenticationToken authentication);
}
