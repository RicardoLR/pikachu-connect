package com.rich.exception

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
class TypeConverterException extends RuntimeException {
    TypeConverterException(String message) {
        super(message)
    }
}