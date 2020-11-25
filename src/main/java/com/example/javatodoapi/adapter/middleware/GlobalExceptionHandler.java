package com.example.javatodoapi.adapter.middleware;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.javatodoapi.adapter.dto.response.ExceptionResponse;
import com.example.javatodoapi.model.exception.BadRequestException;
import com.example.javatodoapi.model.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity notFound(
            NotFoundException notFoundException,
            WebRequest webRequest
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(notFoundException.getMessage());
        return super.handleExceptionInternal(
                notFoundException, exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity badRequest(
            BadRequestException badRequestException,
            WebRequest webRequest
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(badRequestException.getMessage());
        return super.handleExceptionInternal(
                badRequestException, exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest
        );
    }
}
