package com.jianjieming.homework;

/**
 * 折扣类
 *
 * @author 铭
 */
public class Discount implements Money {

    Consumer consumer = new Consumer();

    public float money() {
        float a = consumer.totalMoney();
        if (a > 5000) {
            System.out.println("打完八折后的总价: " + a * 0.8);
        } else {
            System.out.println("总价为: " + a);
        }
        return a;
    }
}

