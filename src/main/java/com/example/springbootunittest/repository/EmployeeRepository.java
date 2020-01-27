package com.example.springbootunittest.repository;

import com.example.springbootunittest.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
