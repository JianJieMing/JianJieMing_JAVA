package com.lanou3g.demo.aop;

import com.lanou3g.demo.utils.AopUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Component
@Aspect
@Order(20)
public class LoggerAspect extends BaseAspect{

    @Before("allService()")
    public void logBefore(JoinPoint jp){
        String str = AopUtils.getJoinPointName(jp);
        System.out.println(str + "方法开始执行");
    }

    @After("allService()")
    public void logAfter(JoinPoint jp){
        String str = AopUtils.getJoinPointName(jp);
        System.out.println(str + "方法执行结束");
    }


}
