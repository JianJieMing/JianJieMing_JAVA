package com.jianjieming.study.service;

import org.springframework.stereotype.Service;

/**
 * @author 铭
 * DATE: 18/9/18 上午9:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("用户开始登录");
    }
}
