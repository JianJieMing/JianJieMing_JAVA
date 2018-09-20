package com.jianjieming.Test01;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * DATE: 18/9/13 下午2:59
 */
//@Controller
public class LoginAction {
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

    @RequestMapping("/success.action")
    public String success(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("用户名: " + request.getParameter("username"));
        return "forward:suc.action";
//        return "redirect:suc.action";
    }

    @RequestMapping("/suc.action")
    public String suc(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("suc******" + request.getParameter("username"));
        return "success";
    }
}
