package com.pgobi.calculatingdiscounts.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CalculatingDiscountsException extends RuntimeException{

    private final HttpStatus httpStatus;
    public CalculatingDiscountsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
