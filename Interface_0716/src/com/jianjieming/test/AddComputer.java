package com.jianjieming.test;

/**
 * 加法计算器
 *
 * @author 铭
 */
public class AddComputer implements Computable {
    @Override
    public int compute(int x, int y) {
        return x + y;
    }
}
