package com.onlinejudge.test002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Test002Application {

    public static void main(String[] args) {
        SpringApplication.run(Test002Application.class, args);
    }

}
