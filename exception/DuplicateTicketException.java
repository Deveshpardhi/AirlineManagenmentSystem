package com.airline.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateTicketException extends RuntimeException {
    public DuplicateTicketException(String message) {
        super(message);
    }
}
