package com.school.student.exceptions;

import com.school.student.payload.ApiResponseExp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseExp> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponseExp apiResponseExp = ApiResponseExp.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponseExp>(apiResponseExp,HttpStatus.NOT_FOUND);
    }
}
