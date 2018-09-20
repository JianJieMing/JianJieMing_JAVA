package com.jianjieming.bookstore2.controller;

import com.jianjieming.bookstore2.model.service.UserService;
import com.jianjieming.bookstore2.model.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午3:14
 */
public class UserAction {
    private UserService service;

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(3).xml");
        UserAction user = (UserAction) context.getBean("userAction");
        List<User> users = user.service.showAll();
        System.out.println(users);
    }
}
