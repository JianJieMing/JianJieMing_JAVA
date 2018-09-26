package com.lanou3g.demo.aop;

import com.lanou3g.demo.utils.AopUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Component
@Aspect
@Order(10)
public class TimerAspect extends BaseAspect{

    @Before("allService()")
    public void before(){
        System.out.println("Timer Before");
    }

    @After("allService()")
    public void after(){
        System.out.println("Timer After");
    }



    @Around("allService()")
    public Object calculateTime(ProceedingJoinPoint jp){

        try {
            long last = System.currentTimeMillis();
            Object result = jp.proceed();
            long time = System.currentTimeMillis() - last;
            String name = AopUtils.getJoinPointName(jp);
            System.out.println(name + "耗时:" + time + "毫秒");

            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
