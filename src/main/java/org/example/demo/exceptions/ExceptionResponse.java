package org.example.demo.exceptions;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExceptionResponse {
    private String errorCode;
    private String message;
    private Map<String, String> errors;

    public ExceptionResponse() {
        this.errors = new HashMap<>();
    }

    public ExceptionResponse(String errorCode, String message, List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        this();
        this.errorCode = errorCode;
        this.message = message;
        for (ObjectError error : globalErrors) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }
        for (FieldError error : fieldErrors) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
