package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LangSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangSchoolApplication.class, args);
    }

}
