package com.ivansan.blogfinalproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// ResourceNotFoundException is used to handle 404 error (not found)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PaginationException extends BlogException{
    // PaginationException is used to handle pagination error
    // - this exception is thrown when the page number is greater than the total pages
    public PaginationException(String message) {
        super(message);

    }
}
