package com.rich.client.exception

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
class PokemonApiException extends RuntimeException {
    PokemonApiException(String message) {
        super(message)
    }
}