package com.example.javatodoapi.model.exception;

public class BadRequestException extends RuntimeException {
    public  BadRequestException(String message) {
        super(message);
    }

    public  BadRequestException(String message, Exception exception) {
        super(message, exception);
    }
}
