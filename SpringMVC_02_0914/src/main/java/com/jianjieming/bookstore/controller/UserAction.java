package com.jianjieming.bookstore.controller;

import com.jianjieming.bookstore.model.service.UserService;
import com.jianjieming.bookstore.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/14 下午2:41
 */
@Controller
public class UserAction {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

    @RequestMapping("/message.action")
    public String message(Model map) {
        List<User> users = userService.showAll();
        map.addAttribute("users", users);
        return "message";
    }

    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }

    @RequestMapping("/message2.action")
    public String message2() {
        return "login";
    }

}
