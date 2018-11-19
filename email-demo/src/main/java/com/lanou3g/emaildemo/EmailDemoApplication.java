package com.lanou3g.emaildemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailDemoApplication.class, args);
    }
}