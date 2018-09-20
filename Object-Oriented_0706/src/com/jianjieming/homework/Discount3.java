package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Discount3 implements Money {

    Consumer consumer = new Consumer();

    @Override
    public float money() {
        float c = consumer.totalMoney();
        if (c > 5000) {
            c = c - 500;
            System.out.println("满5000减500后的总价: " + c);
        } else {
            System.out.println("总价为: " + c);
        }
        return c;
    }
}
