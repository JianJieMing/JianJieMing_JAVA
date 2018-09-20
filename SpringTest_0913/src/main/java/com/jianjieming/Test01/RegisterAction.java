package com.jianjieming.Test01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 铭
 * DATE: 18/9/13 下午7:55
 */
@Controller
public class RegisterAction {
    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }

    @RequestMapping("/success.action")
    public String success(String username, String password, ModelMap map) {
        map.addAttribute("username", username);
        map.addAttribute("password", password);
        return "success";
    }
}
