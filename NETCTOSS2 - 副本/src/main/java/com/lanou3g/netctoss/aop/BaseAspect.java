package com.lanou3g.netctoss.aop;

import org.aspectj.lang.annotation.Pointcut;


public class BaseAspect {

    @Pointcut("execution(* com.lanou3g.netctoss.*.service.*.*(..))")
    public void allService() {
    }

}
