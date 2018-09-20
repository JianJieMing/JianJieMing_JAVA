package com.jianjieming.study;

/**
 * @author 铭
 */
public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Waiter().start();
        }

        Waiter w = new Waiter();
        w.start();
        Thread.sleep(3000);
        System.out.println("主线程开始通知");
        synchronized (Waiter.o){
            Waiter.o.notifyAll();
        }
    }
}
