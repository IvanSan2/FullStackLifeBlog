package com.ivansan.blogfinalproject.security;

import com.ivansan.blogfinalproject.config.RSAKeyProperties;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
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

// this annotation is used to tell spring that this class is a configuration class
@Configuration
// this annotation is used to enable the WebSecurity
// web security is a feature that is used to secure the web application
// this feature is used to secure the web application by using the authentication and authorization
@EnableWebSecurity
// this annotation is used to enable the method security
// this means that we can use the security feature in the method level such as @PreAuthorize, @PostAuthorize, etc.
// also we can use the security feature in the class level such as @Secured, @RolesAllowed, etc
@EnableMethodSecurity
// requiredArgsConstructor is used to create a constructor that will be used to inject the final field
@RequiredArgsConstructor
public class SecurityConfig {

    private final RSAKeyProperties keyProperties;

    @Bean
    // corsConfigurationSource is used to configure the cors configuration source
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://127.0.0.1:3000", "http://localhost:3000"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin", "Cache-Control", "Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // return the security filter chain
        // the security filter chain is used to configure the security of the http request
        return http
                // cors is used to configure the cors
                // Customizer.withDefaults() is used to configure the cors with the default configuration
                .cors(Customizer.withDefaults())
                // disable csrf
                // -csrf is a security feature that is used to prevent the attack that is called Cross-Site Request Forgery
                .csrf(AbstractHttpConfigurer::disable)
                // authorizeHttpRequests is used to configure the authorization of the http request
                // anyRequest is used to authorize any request
                // authenticated is used to authorize the request that is authenticated
                .authorizeHttpRequests(
                        // auth is used to configure the authorization of the http request
                        auth -> {
                            // allow access to /api/v1/auth/** for everyone
                            auth.requestMatchers("/api/v1/auth/**").permitAll();
                            // allow access to /api/v1/** for authenticated user
                            auth.requestMatchers("/api/v1/**").authenticated();
                            // permit any request that doesn't start with /api/v1/auth
                            auth.anyRequest().authenticated(); // docs and swagger

                            }
                )
                // sessionManagement is used to configure the session management
                // sessionCreationPolicy is used to configure the session creation policy
                // STATELESS is used to configure the session creation policy to be stateless
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // oauth2ResourceServer is used to configure the oauth2 resource server
                // jwt is used to configure the jwt
                .oauth2ResourceServer(oauth -> oauth.jwt(jwtConfigurer -> {
                        // jwtAuthenticationConverter is used to configure the jwt authentication converter
                        var converter = new JwtAuthenticationConverter();
                        // grantedAuthoritiesConverter is used to configure the granted authorities converter
                        var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
                        // authorityPrefix is used to configure the authority prefix (by default it is "SCOPE_") (we don't use prefix)
                        grantedAuthoritiesConverter.setAuthorityPrefix("");
                        // setJwtGrantedAuthoritiesConverter is used to set the granted authorities converter
                        converter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
                        // jwtAuthenticationConverter is used to configure the jwt authentication converter
                        jwtConfigurer.jwtAuthenticationConverter(converter);
                    }))
                // httpBasic is used to configure the http basic authentication
                // .httpBasic(Customizer.withDefaults())
                // formLogin is used to configure the form login
                //.formLogin(Customizer.withDefaults()) // we don't use form login
                .build();


    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyProperties.publicKey()).build();
    }

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
