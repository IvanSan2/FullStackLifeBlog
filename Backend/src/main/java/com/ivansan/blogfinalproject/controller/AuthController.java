package com.ivansan.blogfinalproject.controller;

import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;
import com.ivansan.blogfinalproject.dto.UserResponseDTO;
import com.ivansan.blogfinalproject.service.AuthService;
import com.ivansan.blogfinalproject.service.OAuth2Service;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final OAuth2Service oAuth2Service;
    private final OAuth2AuthorizedClientService authorizedClientService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var resDto = authService.login(dto);
        return ResponseEntity.ok(resDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO dto, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.created(uriBuilder.path("/api/v1/auth/login").build().toUri()).body(authService.register(dto));
    }

    @GetMapping("/oauth2/authorize/google")
    public void oauth2AuthorizeGoogle() {
        // Empty method that redirects to the Google authorization page
    }

    @GetMapping("/oauth2/authorize/github")
    public void oauth2AuthorizeGithub() {
        // Empty method that redirects to the GitHub authorization page
    }


    @GetMapping("/oauth2/success")
    public ResponseEntity<LoginResponseDTO> oauth2Success(HttpSession session) {
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) session.getAttribute("oauth2Authentication");
        if (authentication != null) {
            System.out.println(STR."From Controller: \{authentication.toString()}");
            // Удаление OAuth2AuthenticationToken из сессии после использования
            session.removeAttribute("oauth2Authentication");
            return ResponseEntity.ok(oAuth2Service.registerAndLogin(authentication));
        } else {
            // Обработка случая, когда аутентификация не найдена в сессии
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @Hidden
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> userDetails(Authentication authentication) {
        return ResponseEntity.ok(
                Map.of(
                        "username", authentication.getName(),
                        "authorities", authentication.getAuthorities()
                )
        );
    }
}
