package com.jianjieming.test;

import com.jianjieming.study.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 铭
 * DATE: 18/9/18 下午3:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-AOP.xml")
public class SpringAopTest {

    @Autowired
    private UserService userService;

    @Test
    public void aopTest(){
        userService.login();
    }
}
