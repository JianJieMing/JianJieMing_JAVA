package com.jianjieming.test;

import com.jianjieming.study.service.OrderService;
import com.jianjieming.study.service.OrderServiceLog;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 铭
 * DATE: 18/9/18 上午10:18
 */
public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void before() {
        orderService = new OrderServiceLog();
        // AspectJ框架也可以实现静态代理.
    }

    @Test
    public void findAllTest() {
        orderService.findAll();
    }
}