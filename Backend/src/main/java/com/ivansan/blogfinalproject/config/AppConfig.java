package com.ivansan.blogfinalproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// this annotation is used to tell spring that this class is a configuration class
// configuration class is a class that is used to configure the spring application
@Configuration
public class AppConfig {

    // this method is used to create a bean of ModelMapper that will be stored in the spring container
    @Bean
    ModelMapper getModelMapper() {
        // ModelMapper is a library that helps us to map the data from one object to another object
        return new ModelMapper();
    }

    // this method is used to create a bean of PasswordEncoder that will be stored in the spring container
    // PasswordEncoder is an interface that is used to encode the password
    // BCryptPasswordEncoder is an encoder that is used to encode the password using BCrypt algorithm
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
