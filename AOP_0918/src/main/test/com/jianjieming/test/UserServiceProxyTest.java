package com.jianjieming.test;

import com.jianjieming.study.proxy.LogProxy;
import com.jianjieming.study.service.UserService;
import com.jianjieming.study.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 铭
 * DATE: 18/9/18 上午10:32
 */
public class UserServiceProxyTest {

    /*
        动态代理:
            1. 使用的是JDK反射框架下的代理类,
               只能针对有接口的类进行扩展功能.

            2. 使用第三方的CGLib框架,
               只能针对没有接口但是可继承的类扩展功能.
    */

    private UserService service;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl();
        service = LogProxy.newProxyInstance(service);
//        // 获取需要代理的类,所实现的接口.
//        Class[] interfaces = {UserService.class};
////        Class<?>[] classes = service.getClass().getInterfaces();
//        // 获取类加载器
//        ClassLoader classLoader = service.getClass().getClassLoader();
//        Object o = Proxy.newProxyInstance(classLoader, interfaces, new LogProxy(service));
//        service = (UserService) o;
    }

    @Test
    public void loginTest() {
        service.login();
    }

}
