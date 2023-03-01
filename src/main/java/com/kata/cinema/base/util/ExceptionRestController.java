package com.kata.cinema.base.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestControllerAdvice
public class ExceptionRestController extends RuntimeException {
    @ExceptionHandler
    public ErrorResponse errorResponse(final Exception e) {
        return new ErrorResponse(Date.from(Instant.now()), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}