package com.example.user.exception;

public class UserIdException extends RuntimeException {
    public UserIdException(String message) {
        super(message);
    }

    public UserIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
