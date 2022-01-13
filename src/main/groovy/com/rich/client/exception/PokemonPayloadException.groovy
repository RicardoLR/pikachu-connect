package com.rich.client.exception

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
class PokemonPayloadException extends RuntimeException {
PokemonPayloadException(String message) {
        super(message)
    }
}