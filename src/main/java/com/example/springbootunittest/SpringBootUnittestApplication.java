package com.example.springbootunittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class SpringBootUnittestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUnittestApplication.class, args);
    }

}
