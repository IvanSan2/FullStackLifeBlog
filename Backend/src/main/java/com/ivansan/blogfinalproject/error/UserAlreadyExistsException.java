package com.ivansan.blogfinalproject.error;

public class UserAlreadyExistsException extends BlogException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException() {
        super("User already exists or email already exists.");
    }

    public UserAlreadyExistsException(String username, String email) {
        super(STR."User with username \{username} or email \{email} already exists.");
    }
}
