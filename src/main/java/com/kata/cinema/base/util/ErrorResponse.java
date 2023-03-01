package com.kata.cinema.base.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Date timestamp;

    private String message;

    private HttpStatus httpStatus;

    private int code;

    public ErrorResponse(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
