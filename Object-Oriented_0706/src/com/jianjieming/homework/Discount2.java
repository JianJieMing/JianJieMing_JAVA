package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Discount2 implements Money {

    Consumer consumer = new Consumer();

    @Override
    public float money() {
        float b = consumer.totalMoney();
        if (b > 20000) {
            b = b - 5000;
            System.out.println("满20000减5000后的总价: " + b);
        } else {
            System.out.println("总价为: " + b);
        }
        return b;
    }
}
