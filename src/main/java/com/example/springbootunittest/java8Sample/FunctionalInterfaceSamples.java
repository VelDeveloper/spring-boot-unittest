package com.example.springbootunittest.java8Sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaceSamples {

    public static void main(String[] args) {
        // consumer interface represents an operation that accepts a single input argument and returns no result.
        Consumer<String> cons = (st) -> System.out.println(st.toLowerCase());
        cons.accept("Java programming.");

        // Predicate interface represents a predicate (boolean-values function) of one argument.
        Predicate<Integer> pr = a -> (a > 10);
        System.out.println(pr.test(11));

        // It represents an operation on a single operand that returns a result of the same type as its operand.
        UnaryOperator<String> str = (x) -> x.toUpperCase();
        System.out.println(str.apply("hello java"));

        //It represents a supplier of results
        // The supplier can be used in all contexts where there is no input but an output is expected.
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Supplier random value: "+randomValue.get());

        // It represents a function that accepts one argument and returns a result
        Function<String, String> functionExample = s -> {
            return message(s);
        };
        System.out.println(functionExample.apply("World!"));

        String[] names = {"Kevin","Alan","Adam","Joe","Kate"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        Map<String,Integer> map = new HashMap<>();
        map.put("A",10);
        map.put("B",20);
        map.put("C",30);

        map.forEach((key,value)-> System.out.println(key+"-"+value));
    }

    static String message(String s) {
        return "Hello "+s;
    }

    static void messageempty() {
        System.out.println("Hello ");
    }
}
