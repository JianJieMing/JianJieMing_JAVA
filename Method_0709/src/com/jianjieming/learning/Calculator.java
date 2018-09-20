package com.jianjieming.learning;

/**
 * 计算器类
 * 求两个数的和
 *
 * @author 铭
 */
public class Calculator {

    /*
        如果调用某个方法之后,需要有一个执行的结果,
        那么该结果就叫返回值.
        在方法的返回值类型位置明确指出该类型.

        如果某个方法有返回值类型,那么必须使用return关键字,
        将方法的结果返回.
     */

    public int add(int x, int y) {
//        int sum = x + y;
//        System.out.println(x + " + " + y + " = " + sum);
        return x + y;
    }

    public int abs(int n) {
        if (n > 0) {
            return n;
        } else {
            return -n;
        }

//        return n > 0 ? n : -n;

    }

}
