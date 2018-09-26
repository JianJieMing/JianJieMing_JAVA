package com.lanou3g.demo.utils;

import org.aspectj.lang.JoinPoint;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
public class AopUtils {

    public static String getJoinPointName(JoinPoint jp) {
        StringBuilder sb = new StringBuilder();
        Object target = jp.getTarget();
        sb.append(target.getClass().getName()).append(".");
        String methodName = jp.getSignature().getName();
        sb.append(methodName).append("(");
        Object[] args = jp.getArgs();
        if (args.length > 0) {
            for (Object arg : args) {
                sb.append(arg).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");
        return sb.toString();
    }

}
