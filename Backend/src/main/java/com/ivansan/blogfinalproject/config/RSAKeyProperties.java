package com.ivansan.blogfinalproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

// @ConfigurationProperties is a class-level annotation
// that is used to map the class properties with the properties in the application.properties file.
// The prefix attribute is used to specify the prefix of the properties that are to be mapped with the class properties.
@ConfigurationProperties(prefix = "rsa")
public record RSAKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
