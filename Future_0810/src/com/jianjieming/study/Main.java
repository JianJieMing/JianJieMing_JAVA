package com.jianjieming.study;

import java.util.concurrent.*;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
            java中线程开启有几种方式:
            如果回答一种:
                核心的就是调用Thread对象的start方法.
            两种:
                一种是继承Thread,
                一种是实现Runnable接口,也要利用Thread类才能开启.
            多种:
                上面两种+线程池也能开启线程,
                FutureTask(也是实现Runnable接口).
         */

        JoinRunnable r = new JoinRunnable();
        Thread t = new Thread(r);
        System.out.println("大哥通知小弟买雪糕");
        t.start();
        t.join();
        System.out.println("大哥吃雪糕");

        FutureTask<Integer> task = new FutureTask<>(new IceCallable(10));
        System.out.println("二弟拿着10块钱买雪糕去了");
        new Thread(task).start();
        Integer integer = task.get();
        System.out.println("大哥吃雪糕");
        System.out.println("还剩:" + integer + "块钱");

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Future<?> future = threadPool.submit(task);
        Object result = future.get();

    }
}
