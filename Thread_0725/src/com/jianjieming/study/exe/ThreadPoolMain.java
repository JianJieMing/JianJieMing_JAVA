package com.jianjieming.study.exe;

import java.util.concurrent.*;

/**
 * @author 铭
 */
public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {
/*
    系统提供的线程池.
    Executor    线程池的顶级接口.
    Executors   线程池相关的工具类.
*/
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 15; i++) {
            pool.execute(new MyRun(i + 1));
        }

        Thread.sleep(10000);

        for (int i = 0; i < 13; i++) {
            pool.execute(new MyRun(i + 1));
        }

    }

    public static class MyRun implements Runnable {
        private int index;

        public MyRun(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("线程编号为: " + index);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
