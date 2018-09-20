package com.jianjieming.test;

/**
 * @author 铭
 */
public class Player {
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("我猜: " + number);
    }

}
