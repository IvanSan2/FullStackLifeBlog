package com.ivansan.blogfinalproject.error;

public class UserAlreadyExistException extends BlogException {
    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException() {
        super("User already exists or email already exists.");
    }

    public UserAlreadyExistException(String username, String email) {
        super(STR."User with username \{username} or email \{email} already exists.");
    }
}
