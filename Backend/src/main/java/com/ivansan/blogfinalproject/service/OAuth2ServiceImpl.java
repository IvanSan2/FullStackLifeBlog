package com.ivansan.blogfinalproject.service;


import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;

import com.ivansan.blogfinalproject.error.AuthenticationException;
import com.ivansan.blogfinalproject.repository.RoleRepository;
import com.ivansan.blogfinalproject.repository.UserRepository;
import com.ivansan.blogfinalproject.security.OAuthAttributes;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.Arrays.stream;


@Service
@RequiredArgsConstructor
public class OAuth2ServiceImpl implements OAuth2Service  {

    @Value("${oauth2.fixed-password}")
    private String oauth2FixedPassword;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final JWTService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public LoginResponseDTO registerAndLogin(Authentication authentication) {
        // get All attributes from the OAuth2User
        OAuthAttributes oAuthAttributes = OAuthAttributes.of(authentication);

        // create a new UserRequestDTO
        UserRequestDTO userRequestDTO = new UserRequestDTO(
                oAuthAttributes.getName(),
                passwordEncoder.encode(oauth2FixedPassword),
                oAuthAttributes.getEmail(),
                oAuthAttributes.getPicture(),
                oAuthAttributes.getProvider().toString(),
                oAuthAttributes.getProviderId()
        );

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO(
                oAuthAttributes.getEmail(),
                oauth2FixedPassword
        );
        // check if the username or email already exists
        if (userRepository.existsByEmailIgnoreCase(userRequestDTO.getEmail())) {
            // if the username or email already exists, logins the user and returns the jwt
        return new LoginResponseDTO(jwtService.jwtToken(new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password())));
        }
        // else, create a new user, logins the user and returns the jwt

        // map the UserRequestDTO to a User
        var user = modelMapper.map(userRequestDTO, com.ivansan.blogfinalproject.entity.User.class);
        user.setPassword(passwordEncoder.encode(oauth2FixedPassword));

        var role = roleRepository.findByNameIgnoreCase("ROLE_USER").orElseThrow();
        user.setRoles(Set.of(role));

        var savedUser = userRepository.save(user);

        return new LoginResponseDTO(jwtService.jwtToken(new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password())));

    }




}
