package com.jianjieming.study.controller;

import com.jianjieming.study.Modle.service.UserService;
import com.jianjieming.study.Modle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午4:51
 */
@Controller
public class UserAction {
    @Autowired
    private UserService userService;

    @Override
    public String toString() {
        return "UserAction{" +
                "userService=" + userService +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        List<User> users = userAction.userService.showAll();
        System.out.println(users);
    }
}