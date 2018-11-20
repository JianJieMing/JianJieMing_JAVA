package com.lanou3g.balancedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BalanceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalanceDemoApplication.class, args);
    }

    @RequestMapping("test")
    public String test() {
        System.out.println("负载均衡Demo");
        return "Hello World";
    }

}
