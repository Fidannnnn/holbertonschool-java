package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(CPFException.class)
    public ResponseEntity<UserErrorResponse> handleCPFException(CPFException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered CPF " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(uer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<UserErrorResponse> handleUserNameException(UserNameException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered USERNAME " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(uer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserIdException.class)
    public ResponseEntity<UserErrorResponse> handleUserIdException(UserIdException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered ID " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(uer, HttpStatus.NOT_FOUND);
    }

    // (Optional) generic fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserErrorResponse> handleGeneric(Exception err) {
        UserErrorResponse uer = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid request: " + err.getMessage()
        );
        return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST);
    }
}
