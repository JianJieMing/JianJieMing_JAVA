package com.jianjieming.study.service;

/**
 * @author 铭
 * DATE: 18/9/18 上午9:51
 */
public class UserServiceLog implements UserService {
    private UserService userService;

    public UserServiceLog(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login() {
        System.out.println("UserService.login 开始执行");
        userService.login();
        System.out.println("UserService.login 执行结束");
    }
}
