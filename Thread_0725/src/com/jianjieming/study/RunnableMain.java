package com.jianjieming.study;

/**
 * @author 铭
 */
public class RunnableMain {
    public static void main(String[] args) {
//        第二种开启线程的方式.
        for (int i = 0; i < 5; i++) {
            MyRunnable r = new MyRunnable();
            Thread t = new Thread(r, "影分身" + i);
            t.start();
        }

//        简写1
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

//        简写2
        new Thread(new MyRunnable()).start();

//        随便开个线程
        new Thread(() -> {
//                输出当前线程的名字
            System.out.println(Thread.currentThread().getName());
        }).start();

//        lambda
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

    }
}
