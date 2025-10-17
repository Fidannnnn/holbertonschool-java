package com.example.user.exception;

public class CPFException extends RuntimeException {
    public CPFException(String message) {
        super(message);
    }

    public CPFException(String message, Throwable cause) {
        super(message, cause);
    }
}
