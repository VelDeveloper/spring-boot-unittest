package com.example.springbootunittest.java8Sample;

import com.example.springbootunittest.model.Department;
import com.example.springbootunittest.model.Employee;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleStreams {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071");

        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));

        System.out.println("Look after stream");
        // See we need 2-iteration to add, sort and print
        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumber = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumber = Stream.of("N40","N41","N42","N43","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumber, inNumber);
//        System.out.println(concatStream.count());
//        System.out.println(concatStream.distinct().count()); //will remove duplicates
        System.out.println(concatStream
        .distinct()
        .peek(System.out::println)
        .count());

        Employee vadivel = new Employee("206","Vadivel","M","Software", 26);
        Employee venkat = new Employee("207","venkat","M","Software", 25);
        Employee dinesh = new Employee("208","dinesh","M","Software", 28);
        Employee siva = new Employee("209","siva","M","Software", 28);
        Employee rajesh = new Employee("210","rajesh","M","Software", 26);

        Department hr = new Department();
        hr.setName("Human Resources");
        hr.addEmployee(vadivel);
        hr.addEmployee(venkat);
        hr.addEmployee(dinesh);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.addEmployee(siva);
        accounting.addEmployee(rajesh);

        List<Department> departments = Arrays.asList(hr, accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(employee -> System.out.println(employee.getName()));

        Map<Integer, List<Employee>> groupigByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count();

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i%2 ==1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(lambdaFunction.apply("1234567890"));
        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        Supplier<String> iLoveJava = () -> "I Love Java!";
//        Supplier<String> iLoveJava = () -> {return "I Love Java!";};
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob");
        topNames2015.stream()
                .map(name -> StringUtils.capitalize(name))
                .sorted()
                .forEach(System.out::println);
        Long numberOfNameStartsWithA = topNames2015.stream()
                .map(name -> StringUtils.capitalize(name))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("numberOfNameStartsWithA::"+numberOfNameStartsWithA);
        topNames2015.stream()
                .map(name -> StringUtils.capitalize(name))
                .peek(System.out::println)
                .sorted(); //It doesn't have terminla operation so it didn't evaluate anything. Remember stream is lazy not eager.
        List<String> string= topNames2015.stream()
                .map(name -> StringUtils.capitalize(name))
                .peek(System.out::println) //Used to check the intermediate result
                .sorted().collect(Collectors.toList());

    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
