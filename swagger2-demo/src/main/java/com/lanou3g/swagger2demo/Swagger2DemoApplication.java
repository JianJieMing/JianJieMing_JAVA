package com.lanou3g.swagger2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Swagger2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Swagger2DemoApplication.class, args);
    }

}
