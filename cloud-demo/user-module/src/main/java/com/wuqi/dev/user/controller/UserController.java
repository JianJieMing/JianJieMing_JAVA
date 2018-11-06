package com.wuqi.dev.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人: 武奇
 * 创建事件: 2018/11/5
 */
@RestController
@RequestMapping("/auth")
public class UserController {


    @GetMapping("/home")
    public String home() {
        return "Auth/HomePage";
    }
}
