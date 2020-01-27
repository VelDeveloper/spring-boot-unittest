package com.example.springbootunittest.java8Sample;

import com.example.springbootunittest.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExamples {
    public static void main(String[] args) {
        Person person = new Person("Vadivel");
//        Person person = null;
        Optional<Person> personOptional = Optional.ofNullable(person);
        personOptional.ifPresent(person1 -> System.out.println(person1.getName()));

        Stream.of(10,20,30).findFirst().ifPresent(System.out::println);
        Stream<Integer> numbers = Stream.iterate(1, n->n+1).limit(10);
        numbers.forEach(n-> System.out.print(n+" "));

        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(10);
        randomNumbers.forEach(n-> System.out.println(n+" "));

        String[] title = {"This","is","just","an","example"};
        Stream<String> stream = Arrays.stream(title);
        Optional<String> result = stream.reduce((word1,word2)->word1+"-"+word2);
        System.out.println(result.get());

        List<String> femaleNames = Arrays.asList("Kate","Judy","Nicole");
        List<String> maleNames = Arrays.asList("Kevin","Peter","Joe");
        List<List<String>> names = Arrays.asList(femaleNames, maleNames);

        System.out.println(names);
        names.stream().map(list->list.stream()).collect(Collectors.toList()).forEach(System.out::println);
        names.stream().flatMap(list->list.stream()).collect(Collectors.toList()).forEach(System.out::println);

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Kevin");
        map.put(2, "Joe");
        map.put(3, "Adam");
        map.put(4, "July");
        map.put(5, "Donald");

        Map<Integer,String> resultMap = map.entrySet().stream().filter(map1->map1.getKey()<=4).skip(2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(resultMap);
    }
}
