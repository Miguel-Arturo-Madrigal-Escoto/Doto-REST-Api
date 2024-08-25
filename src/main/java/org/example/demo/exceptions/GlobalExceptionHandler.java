package org.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> handleBindException(BindException ex) {
        String errorCode = HttpStatus.BAD_REQUEST.toString();
        String message = "There are validation errors in the submitted data.";

        ExceptionResponse errorResponse = new ExceptionResponse(
                errorCode,
                message,
                ex.getGlobalErrors(),
                ex.getFieldErrors()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
