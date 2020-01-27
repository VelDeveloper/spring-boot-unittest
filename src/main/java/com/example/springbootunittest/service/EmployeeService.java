package com.example.springbootunittest.service;

import com.example.springbootunittest.exceptions.EmployeeException;
import com.example.springbootunittest.model.Employee;
import com.example.springbootunittest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String employeeId) {
        Optional<Employee> byId = employeeRepository.findById(employeeId);
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException("Employee with ID: "+employeeId+" Not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.findById(employee.getEmployeeId())
                .map(employee1 -> employeeRepository.save(employee))
                .orElseGet(() -> employeeRepository.insert(employee));
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.delete(
                employeeRepository.findById(employeeId)
                        .orElseThrow(() -> new EmployeeException("Employee with ID: "+employeeId+" Not found")));
    }
}
