package com.jianjieming.test;

import com.jianjieming.study.service.UserService;
import com.jianjieming.study.service.UserServiceImpl;
import com.jianjieming.study.service.UserServiceLog;
import com.jianjieming.study.service.UserServiceTimer;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 铭
 * DATE: 18/9/18 上午9:45
 */
public class UserServiceTest {

    private UserService service;

    // 静态代理
    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl();
        service = new UserServiceLog(service);
        service = new UserServiceTimer(service);
    }

    @Test
    public void loginTest() {
        service.login();
    }
}