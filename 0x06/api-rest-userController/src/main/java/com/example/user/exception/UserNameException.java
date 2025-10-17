package com.example.user.exception;

public class UserNameException extends RuntimeException {
    public UserNameException(String message) {
        super(message);
    }

    public UserNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
