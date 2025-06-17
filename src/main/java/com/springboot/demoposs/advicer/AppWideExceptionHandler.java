package com.springboot.demoposs.advicer;

import com.springboot.demoposs.exception.NotFoundException;
import com.springboot.demoposs.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "error coming", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
