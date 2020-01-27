package com.example.springbootunittest.java8Sample;

import com.example.springbootunittest.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class RunnableEmployee {

    public static void main(String[] args) {
        Employee employee0 = new Employee("206","Vadivel Murugan","M","Software Engineer",32);
        Employee employee1 = new Employee("207","Dinesh Kandasamy","M","Software Engineer",30);
        Employee employee2 = new Employee("208","Nagaraj Gopal","M","Software Engineer",26);
        Employee employee3 = new Employee("209","Chellak Kumaran","M","Software Engineer",26);
        Employee employee4 = new Employee("210","Dhana Venkatesh","M","Software Engineer",36);
        List<Employee> employees = Arrays.asList(employee0, employee1, employee2, employee3, employee4);
        printEmployeeByAge(employees, employee5 -> employee5.getAge() > 30);
        printEmployeeByAge(employees, employee5 -> employee5.getAge() <= 30);

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a+5));
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        //Supplier
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

        for (int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }

        employees.forEach(emp -> {
            System.out.println("Last name is:"+emp.getName().substring(emp.getName().indexOf(' ') + 1));
        });

        // first one is the argument and 2nd one is the return type
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' '));
        };
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);
        String firstName = getLastName.apply(employees.get(1));
        System.out.println(firstName);

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> uppercase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName1 = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = uppercase.andThen(firstName1);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
          return name.concat(" "+ employee.getAge());
        };
        System.out.println(concatAge.apply(uppercase.apply(employees.get(0)), employees.get(0)));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }
    private static void printEmployeeByAge(List<Employee> employees, Predicate<Employee> employeePredicate) {
        System.out.println("Employees to print");
        for (Employee employee : employees) {
            if (employeePredicate.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
