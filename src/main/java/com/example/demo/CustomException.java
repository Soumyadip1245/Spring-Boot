package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(StudentNotFoundException.class)
    ResponseEntity<Error> handleError(StudentNotFoundException ex){
        Error e = new Error();
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_FOUND.value());
        e.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
    }
}
