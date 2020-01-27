package com.example.springbootunittest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EmployeeAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeException.class)
    public final ResponseEntity<Object> employeeNotFoundResponseResponseEntity(EmployeeException ex){
        EmployeeNotFoundResponse response = new EmployeeNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
