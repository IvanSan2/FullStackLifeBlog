package com.ivansan.blogfinalproject.controller;

import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;
import com.ivansan.blogfinalproject.dto.UserResponseDTO;
import com.ivansan.blogfinalproject.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto
    ) {
        var loginResponseDTO = authService.login(dto);
        return ResponseEntity.ok(loginResponseDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @RequestBody @Valid UserRequestDTO userRequestDTO,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        var userResponseDTO = authService.register(userRequestDTO);
        var uri = uriComponentsBuilder.path("/api/v1/auth/login").build().toUri();
        return ResponseEntity.created(uri).body(userResponseDTO);
    }


}
