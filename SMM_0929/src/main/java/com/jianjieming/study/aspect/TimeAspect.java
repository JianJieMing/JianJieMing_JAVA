package com.jianjieming.study.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 铭
 * 2018/10/8 11:10
 */
@Component
@Aspect
public class TimeAspect {

    @Pointcut("execution(* com.jianjieming.study.service.*.*(..))")
    public Object time(ProceedingJoinPoint jp) {
        long last = System.currentTimeMillis();
        try {
            Object proceed = jp.proceed();
            long time = System.currentTimeMillis() - last;
            Logger logger = Logger.getLogger(jp.getTarget().getClass());
            logger.info(
                    jp.getTarget().getClass() +
                            "." + jp.getSignature().getName() +
                            "执行了" + time + "毫秒"
            );
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
