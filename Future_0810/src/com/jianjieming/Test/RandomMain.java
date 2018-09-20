package com.jianjieming.Test;

import java.util.Random;
import java.util.concurrent.*;

public class RandomMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 生成50000000个随机数,
         * 计算总耗时
         */
        long millis = System.currentTimeMillis();
        final Random r = new Random();
        for (int i = 0; i < 250000000; i++) {
            r.nextInt();
        }
        System.out.println("单线程50000000次, 耗时: " + (System.currentTimeMillis() - millis));

        ExecutorService pool = Executors.newFixedThreadPool(5);

        long totalTime = 0;
        for (int i = 0; i < 5; i++) {
            Future<Long> future = pool.submit(new RandomCallable(1));
            totalTime += future.get();
        }
        System.out.println("多线程使用同一个Random对象, 耗时:" + totalTime);

        totalTime = 0;
        for (int i = 0; i < 5; i++) {
            Future<Long> future = pool.submit(new RandomCallable(2));
            totalTime += future.get();
        }
        System.out.println("多线程使用独立的Random对象, 耗时:" + totalTime);

        pool.shutdown();

    }
}
