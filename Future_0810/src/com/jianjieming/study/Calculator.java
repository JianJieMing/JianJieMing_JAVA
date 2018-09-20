package com.jianjieming.study;

/**
 * @author 铭
 */
public class Calculator implements AddCalculator, MinusCalculator {
    @Override
    public int add(int x, int y) {
        return 0;
    }

    @Override
    public int minus(int x, int y) {
        return 0;
    }

    @Override
    public void fun() {
//        AddCalculator.super.fun();
        MinusCalculator.super.fun();
    }
}
