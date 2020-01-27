package com.example.springbootunittest.controller;

import com.example.springbootunittest.model.Employee;
import com.example.springbootunittest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Employee>> listEmployees() {
        return ResponseEntity.ok(employeeService.listEmployees());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
