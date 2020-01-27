package com.example.springbootunittest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Document
//@TypeAlias("employee-model")
public class Employee {

//    @Id
    String employeeId;
    String name;
    String sex;
    String designation;
    int age;
}
