package com.jianjieming.Test01;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 铭
 * DATE: 18/9/13 下午7:55
 */
//@Controller
public class LoginAction {
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

    @RequestMapping("/success.action")
    public String success(String username, String password, ModelMap map) {
        map.put("username", username);
        map.put("password", password);
        return "success";
    }
}
