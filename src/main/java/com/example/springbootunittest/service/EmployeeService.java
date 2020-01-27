package com.example.springbootunittest.service;

import com.example.springbootunittest.model.Employee;
import com.example.springbootunittest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

//    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmployees() {
        return null;
//        return employeeRepository.findAll();
    }

    public Employee getEmployee(String employeeId) {
        return null;
//        Optional<Employee> byId = employeeRepository.findById(employeeId);
//        return employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new EmployeeException("Employee with ID: "+employeeId+" Not found"));
    }

    public Employee createEmployee(Employee employee) {
        return null;
//        return employeeRepository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return null;
//        return employeeRepository.findById(employee.getEmployeeId())
//                .map(employee1 -> employeeRepository.save(employee))
//                .orElseGet(() -> employeeRepository.insert(employee));
    }

    public void deleteEmployee(String employeeId) {
        return;
//        employeeRepository.delete(
//                employeeRepository.findById(employeeId)
//                        .orElseThrow(() -> new EmployeeException("Employee with ID: "+employeeId+" Not found")));
    }
}
