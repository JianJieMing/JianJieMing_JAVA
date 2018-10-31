package com.lanou3g.springjpademo;

import com.lanou3g.springjpademo.entity.ModuleEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemoApplication.class, args);
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setModuleId(1L);
        Long moduleId = moduleEntity.getModuleId();
        System.out.println(moduleId);

    }

    @RequestMapping("/test")
    public String test() {
        return "Success";
    }

}
