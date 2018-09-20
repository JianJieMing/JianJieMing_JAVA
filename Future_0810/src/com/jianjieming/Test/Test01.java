package com.jianjieming.Test;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author 铭
 */
public class Test01 implements Callable<Long> {

    private long millis1;

    public Test01(long millis1) {
        this.millis1 = millis1;
    }

    @Override
    public Long call() throws Exception {
        long millis2 = System.currentTimeMillis();
        Random r = new Random();
        for (int i = 0; i < 10000000; i++) {
            r.nextInt();
        }
        return millis1 - millis2;
    }
}
