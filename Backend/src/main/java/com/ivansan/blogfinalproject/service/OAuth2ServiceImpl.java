package com.ivansan.blogfinalproject.service;


import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;

import com.ivansan.blogfinalproject.entity.User;

import com.ivansan.blogfinalproject.enums.AuthProvider;
import com.ivansan.blogfinalproject.repository.RoleRepository;
import com.ivansan.blogfinalproject.repository.UserRepository;
import com.ivansan.blogfinalproject.security.OAuthAttributes;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;




@Service
@RequiredArgsConstructor
public class OAuth2ServiceImpl implements OAuth2Service {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JWTService jwtService;
    private final PasswordGeneratorService passwordGeneratorService;
    private final OAuth2AuthorizedClientService authorizedClientService;

    @Value("${oauth2.fixed-password}")
    private String oauth2FixedPassword;

    @Override
    public LoginResponseDTO registerAndLogin(OAuth2AuthenticationToken authentication) {

        String githubEmail = "";

      if ("github".equals(authentication.getAuthorizedClientRegistrationId())) {
            OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
                    authentication.getAuthorizedClientRegistrationId(),
                    authentication.getName());

            String accessToken = authorizedClient.getAccessToken().getTokenValue();
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange("https://api.github.com/user/emails", HttpMethod.GET, entity, String.class);

           githubEmail = response.getBody().split("\"email\":")[1].split("\"")[1];


        }
            OAuthAttributes oAuthAttributes = OAuthAttributes.of(authentication, githubEmail);






        var password = passwordGeneratorService.generateRandomPassword();


        UserRequestDTO userRequestDTO = new UserRequestDTO(
                oAuthAttributes.getName() + oAuthAttributes.getProviderId().substring(oAuthAttributes.getProviderId().length() - 3),
                passwordEncoder.encode(oauth2FixedPassword),
                oAuthAttributes.getEmail(),
                oAuthAttributes.getPicture(),
                oAuthAttributes.getProvider().name(),
                oAuthAttributes.getProviderId()
        );



        LoginRequestDTO loginRequestDTO = new LoginRequestDTO(
                oAuthAttributes.getEmail(),
                oauth2FixedPassword
        );

        if (userRepository.existsByEmailIgnoreCase(userRequestDTO.getEmail())) {
            return new LoginResponseDTO(jwtService.jwtToken(new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password())));
        }

        var user = User.builder()
                .username(userRequestDTO.getUsername())
                .email(userRequestDTO.getEmail())
                .image(userRequestDTO.getImage())
                .provider(AuthProvider.valueOf(userRequestDTO.getProvider()))
                .providerId(userRequestDTO.getProviderId())
                .password(passwordEncoder.encode(oauth2FixedPassword))
                .build();



        var role = roleRepository.findByNameIgnoreCase("ROLE_USER").orElseThrow();
        user.setRoles(Set.of(role));

        userRepository.save(user);

        return new LoginResponseDTO(jwtService.jwtToken(new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password())));
    }
}
