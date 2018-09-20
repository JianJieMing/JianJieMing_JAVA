package com.jianjieming.study.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 铭
 * DATE: 18/9/18 上午11:50
 */
public class TimerProxy implements MethodInterceptor {

    public Object target;

    public TimerProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long last = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long time = System.currentTimeMillis() - last;
        System.out.println("方法执行了: " + time + "毫秒");
        return result;
    }
}
