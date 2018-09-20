package com.jianjieming.Test01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 铭
 * DATE: 18/9/13 下午5:14
 */
@Controller
public class RegisterAction {
    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }

    @RequestMapping("/success.action")
//    public String success(Person person) {
//        Map map = new HashMap();
//        map.put("person", person);
//        return "success";
//    }

    public String success(String username, String password, ModelMap mav) {
        mav.put("username", username);
        mav.addAttribute("password", password);
        return "success";
    }
}
