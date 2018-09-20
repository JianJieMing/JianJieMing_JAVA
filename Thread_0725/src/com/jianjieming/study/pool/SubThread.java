package com.jianjieming.study.pool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 子线程
 *
 * @author 铭
 */
public class SubThread extends Thread {
    //      阻塞队列
    private static final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        try {
            while (true) {
                Runnable take = queue.take();
                take.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(Runnable r) {
        queue.add(r);
    }
}
