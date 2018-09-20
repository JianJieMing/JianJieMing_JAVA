package com.jianjieming.test;

import com.jianjieming.study.proxy.TimerProxy;
import com.jianjieming.study.service.OrderService;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author 铭
 * DATE: 18/9/18 上午11:40
 */
public class OrderServiceProxyTest {

    @Test
    public void findAllTest() {
        OrderService orderService = new OrderService();
        // 使用CGLib进行动态代理.
        Class<? extends OrderService> clazz = orderService.getClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        // 咱们使用Enhancer目的是为了创建出来一个目标类的子类.
        // 所以superclass就得填目标类.
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new TimerProxy(orderService));
        orderService = (OrderService) enhancer.create();
        orderService.findAll();
    }
}
