package com.jianjieming.Test01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 铭
 * DATE: 18/9/13 下午3:50
 */
//@Controller
public class LoginAction2 {
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }

//    @RequestMapping("/success.action")
////    public String success(HttpServletRequest request, HttpServletResponse response) {
////        System.out.println("success******" + request.getParameter("username"));
////        return "success";
////    }
//
////    @RequestMapping("/success.action")
////    public String success(String username, String password) {
////        System.out.println("success******" + username);
////        return "success";
////    }
//
////    @RequestMapping("/success.action")
////    public String success(Person person, String username) {
////        System.out.println("success******" + person.getUsername() + username);
////        return "success";
////    }

    @RequestMapping(value = "/success.action",method = RequestMethod.GET)
    public String success(@RequestParam("username") String userna, String password) {
        System.out.println("success******" + userna + password);
        return "success";
    }
}
