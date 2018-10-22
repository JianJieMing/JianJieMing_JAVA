package com.jianjieming.study.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;


/**
 * @author 铭
 * 2018/10/8 10:53
 */
public class LoggerAspect {

    public void beforeInvoke(JoinPoint jp) {
        Object target = jp.getTarget();
        String name = target.getClass().getName();
        String methodName = jp.getSignature().getName();
        Logger logger = Logger.getLogger(target.getClass());
        logger.info(name + "." + methodName + "开始执行");
    }

    public void afterInvoke(JoinPoint jp) {
        Object target = jp.getTarget();
        String name = target.getClass().getName();
        String methodName = jp.getSignature().getName();
        Logger logger = Logger.getLogger(target.getClass());
        logger.info(name + "." + methodName + "执行完毕");
    }

}
