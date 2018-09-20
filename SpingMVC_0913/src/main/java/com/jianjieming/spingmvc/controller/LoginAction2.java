package com.jianjieming.spingmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * DATE: 18/9/13 下午2:34
 */
@Controller
public class LoginAction2 {
    // 通常函数的返回值是ModelAndView,如果不需要传递参数,返回String类型.
    // 容器会帮助我们进行封装,把String变成viewName,生成一个ModelAndView.
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

    @RequestMapping("/success.action")
    public String success(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("**********" + request.getParameter("username"));
        return "success";
    }
}
