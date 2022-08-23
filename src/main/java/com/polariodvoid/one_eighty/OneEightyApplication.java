package com.polariodvoid.one_eighty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={
        "com.polariodvoid.one_eighty", "com.polariodvoid.one_eighty.Exceptions"})
public class OneEightyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneEightyApplication.class, args);
    }

}
