package com.test.jpatest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DuplicateFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DuplicateNameFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> nameExceptionHandler(DuplicateNameFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(DuplicateEmailFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> emailExceptionHandler(DuplicateEmailFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }

//    @ResponseBody
//    @ExceptionHandler(DuplicateEmailFoundException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public Map<String, String>
}
