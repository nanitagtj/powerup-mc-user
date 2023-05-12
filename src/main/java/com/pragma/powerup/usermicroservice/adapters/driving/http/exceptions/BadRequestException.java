package com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
