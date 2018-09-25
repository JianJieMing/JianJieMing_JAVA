package com.jianjieming.homework.aop;

import org.aspectj.lang.annotation.Pointcut;


public class BaseAspect {

    @Pointcut("execution(* com.jianjieming.homework.service.*.*(..))")
    public void allService() {
    }

}
