package com.example.javatodoapi.adapter.dto;


public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
