package com.jianjieming.study;

import com.jianjieming.Test.Test01;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author 铭
 */
public class RandomMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

         /*
        生成五千万个随机数,计算总耗时.
     */

        long millis = System.currentTimeMillis();
        Random r = new Random();
        for (int i = 0; i < 50000000; i++) {
            r.nextInt();
        }
//        System.out.println(System.currentTimeMillis() - millis);


//        FutureTask<Long> futureTask = new FutureTask(new Test01());
//        new Thread(futureTask).start();
//        Long aLong = futureTask.get();
        long millis1 = System.currentTimeMillis();
        ExecutorService e = Executors.newFixedThreadPool(5);
        Future<?> submit = e.submit(new Test01(millis1));
        Object o = submit.get();
        System.out.println(o);


        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                long l = System.currentTimeMillis();
                for (int i = 0; i < 10000000; i++) {
                    r.nextInt();
                }
                return System.currentTimeMillis() - l;
            }
        };


//        long time = 0;
//        for (int i = 0; i < 5; i++) {
//
//        }


    }

}


