package com.jianjieming.study.service;

/**
 * @author 铭
 * DATE: 18/9/18 上午9:56
 */
public class UserServiceTimer implements UserService {
    private UserService userService;

    public UserServiceTimer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login() {
        long l = System.currentTimeMillis();
        userService.login();
        long time = System.currentTimeMillis() - l;
        System.out.println("UserService.login 耗时: " + time + "毫秒");
    }
}
