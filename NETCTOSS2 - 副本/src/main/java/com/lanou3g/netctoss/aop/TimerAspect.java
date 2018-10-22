package com.lanou3g.netctoss.aop;


import com.lanou3g.netctoss.utils.AopUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


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
