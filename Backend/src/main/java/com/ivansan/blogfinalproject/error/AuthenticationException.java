package com.ivansan.blogfinalproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Authentication failed")
public class AuthenticationException extends BlogException{
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException() {
        super("Authentication failed");
    }
}
