package com.lanou3g.springapigradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringApiGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiGradleApplication.class, args);
    }

    @RequestMapping("/index")
    public String test() {
        return "Success";
    }

}
