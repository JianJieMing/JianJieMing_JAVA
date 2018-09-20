package com.jianjieming.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 铭
 * DATE: 18/9/17 下午8:00
 */
@Controller
public class PersonController {
    @RequestMapping("/person")
    @ResponseBody
    public Person person() {
        Person p = new Person();
        p.setName("张友朋");
        p.setAge(3);
        return p;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
