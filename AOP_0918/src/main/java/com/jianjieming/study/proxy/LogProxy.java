package com.jianjieming.study.proxy;

import com.jianjieming.study.aop.LoggerAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 铭
 * DATE: 18/9/18 上午10:42
 */
public class LogProxy implements InvocationHandler {

    public static <T> T newProxyInstance(T target) {
        Class<?> clazz = target.getClass();
        ClassLoader loader = clazz.getClassLoader();
        Class<?>[] interfaces = clazz.getInterfaces();
        Object proxy = Proxy.newProxyInstance(loader, interfaces, new LogProxy(target));
        return (T) proxy;
    }

    private Object target;
    private LoggerAspect loggerAspect = new LoggerAspect();

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置通知
//        loggerAspect.logBefore();
        Object result = null;
        try {
            result = method.invoke(target, args);
            // 返回通知
            loggerAspect.logAfterReturn();
        } catch (Exception e) {
            e.printStackTrace();
            // 异常通知
            loggerAspect.logAfterThrow();
        }
        // 后置通知
        loggerAspect.logAfter();
        return result;
    }
}
