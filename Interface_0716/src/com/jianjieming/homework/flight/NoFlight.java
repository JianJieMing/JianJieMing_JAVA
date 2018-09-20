package com.jianjieming.homework.flight;

/**
 * @author 铭
 */
public class NoFlight implements Flight {
    @Override
    public void flight() {
        System.out.println("不会飞");
    }
}
