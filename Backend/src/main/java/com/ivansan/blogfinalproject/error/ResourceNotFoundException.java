package com.ivansan.blogfinalproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

// ResourceNotFoundException is used to handle 404 error (not found)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BlogException{
    // constructor with 3 parameters
    // - resource is the name of the resource that is not found
    // - field is the name of the field that is used to search the resource
    // - value is the value of the field that is used to search the resource
    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s with %s=%s not found", resource, field, value));
    }

    public static Supplier<RuntimeException> supply(String resource, String field, String value) {
        return () -> new ResourceNotFoundException(resource, field, value);
    }
}
