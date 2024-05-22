package com.ivansan.blogfinalproject.security;

import com.ivansan.blogfinalproject.entity.Role;
import com.ivansan.blogfinalproject.entity.User;
import com.ivansan.blogfinalproject.enums.AuthProvider;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;


import java.util.Map;
import java.util.Set;


@Getter
@Builder
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private AuthProvider provider;
    private String providerId;


    public static OAuthAttributes of(Authentication authentication, String githubEmail) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        String registrationId = oauthToken.getAuthorizedClientRegistrationId();
        OAuth2User oAuth2User = oauthToken.getPrincipal();
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String userNameAttributeName = oauthToken.getPrincipal().getAttribute("name");


        if ("google".equals(registrationId)) {
            return ofGoogle(userNameAttributeName, attributes);
        } else if ("github".equals(registrationId)) {
            return ofGithub(userNameAttributeName, attributes, githubEmail);
        }
        throw new RuntimeException(STR."Unsupported OAuth2 provider: \{registrationId}");
    }


    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .provider(AuthProvider.GOOGLE)
                .providerId((String) attributes.get("sub"))
                .build();
    }



    private static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes, String githubEmail) {


        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email(githubEmail)
                .picture((String) attributes.get("avatar_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .provider(AuthProvider.GITHUB)
                .providerId(((Integer) attributes.get("id")).toString())
                .build();
    }



    public User toEntity() {
        Set<Role> roles = Set.of(Role.builder().name("ROLE_USER").build());

        return User.builder()
                .username(name)
                .email(email)
                .image(picture)
                .provider(provider)
                .providerId(providerId)
                .roles(roles)
                .build();
    }
}