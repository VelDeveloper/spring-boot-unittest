package com.example.springbootunittest.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundResponse {

    private String employeeNotFound;

    public EmployeeNotFoundResponse(String employeeNotFound) {
        this.employeeNotFound = employeeNotFound;
    }
}
