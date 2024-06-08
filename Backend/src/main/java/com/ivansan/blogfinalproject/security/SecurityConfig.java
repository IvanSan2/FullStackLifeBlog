package com.ivansan.blogfinalproject.security;

import com.ivansan.blogfinalproject.config.OAuth2LoginSuccessHandler;
import com.ivansan.blogfinalproject.config.RSAKeyProperties;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * This class is responsible for the security configuration of the application.
 * It uses Spring Security and OAuth2 for authentication and authorization.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // RSAKeyProperties is a class that holds the public and private keys for JWT encoding and decoding.
    private final RSAKeyProperties keyProperties;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;


    /**
     * This method configures Cross-Origin Resource Sharing (CORS) for the application.
     * It allows requests from specific origins and allows specific HTTP methods.
     * @return CorsConfigurationSource object that holds the CORS configuration.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://127.0.0.1:8080", "http://localhost:8080", "http://localhost:3000", "http://127.0.0.1:3000","https://fullstacklifeblogbackend.onrender.com","https://fullstack-life-blog-frontend-latest.onrender.com"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * This method configures the security filter chain for the application.
     * It sets up the authorization rules for different API endpoints.
     * @param http HttpSecurity object to configure.
     * @return SecurityFilterChain object that holds the security configuration.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll();
//                            auth.requestMatchers(HttpMethod.POST, "/api/v1/**").authenticated();
//                            auth.requestMatchers(HttpMethod.PUT, "/api/v1/**").authenticated();
//                            auth.requestMatchers(HttpMethod.DELETE, "/api/v1/**").authenticated();
                            auth.requestMatchers("/api/v1/auth/**").permitAll();
                            auth.anyRequest().permitAll(); //permit all other requests, swagger-ui etc.
                        }
                )

                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))

                .oauth2ResourceServer(auth -> auth.jwt(jwtConfigurer -> {
                    var jwtAuthenticationConverter = new JwtAuthenticationConverter();
                    var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
                    grantedAuthoritiesConverter.setAuthorityPrefix("");
                    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
                    jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter);
                }))

                //oauth2 login configuration
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login").permitAll()
                        .authorizationEndpoint(authorization -> authorization
                                .baseUri("/api/v1/auth/oauth2/authorize")
                        )
                        .tokenEndpoint(token -> token
                                .accessTokenResponseClient(new DefaultAuthorizationCodeTokenResponseClient())
                        )
                        .loginProcessingUrl("/login/oauth2/code/*")
                        .successHandler(oAuth2LoginSuccessHandler)



                )
                .build();
    }



    /**
     * This method creates a JwtDecoder bean for decoding JWTs.
     * It uses the public key from RSAKeyProperties.
     * @return JwtDecoder object for decoding JWTs.
     */
    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyProperties.publicKey()).build();
    }

    /**
     * This method creates a JwtEncoder bean for encoding JWTs.
     * It uses the public and private keys from RSAKeyProperties.
     * @return JwtEncoder object for encoding JWTs.
     */
    @Bean
    JwtEncoder jwtEncoder() {
        RSAKey rsaKey = new RSAKey.Builder(keyProperties.publicKey())
                .privateKey(keyProperties.privateKey())
                .build();

        //JSON Web Key (JWK) set. Represented by a JSON object that contains an array of JSON Web Keys
        var jwKeySet = new JWKSet(rsaKey);

        //JSON Web Key (JWK) source backed by an immutable JWK set.
        //the security context is used to pass additional parameters to the JWK source, such as the JWS algorithm restrictions
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(jwKeySet);

        //the encoder requires a JWKSource and a SecurityContext
        //finally we can create the encoder:
        return new NimbusJwtEncoder(jwkSource);
    }





}