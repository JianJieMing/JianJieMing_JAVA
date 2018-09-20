package com.jianjieming.study.controller;

import com.jianjieming.study.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * DATE: 18/9/17 下午4:30
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        WebApplicationContext context1 = WebApplicationContextUtils.findWebApplicationContext(context);
        Object xxx = context1.getBean("userService");
        System.out.println(xxx);
        return "login";
    }

    @RequestMapping("/person")
    @ResponseBody
    public Person getOne() {
        Person p = new Person();
        p.setId(1);
        p.setName("张三");
        return p;
    }

}
