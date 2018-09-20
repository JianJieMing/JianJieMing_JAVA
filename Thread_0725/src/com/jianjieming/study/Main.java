package com.jianjieming.study;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        /*
            在java中,线程的类就是Thread
         */

//        新建五个线程,观察执行过程.
        System.out.println("开始创建线程对象: ");
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");
        MyThread t4 = new MyThread("Thread-4");
        MyThread t5 = new MyThread("Thread-5");
        System.out.println("同时开启多个线程");
//        调用Thread对象的start()方法,即可开启线程.
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println("多线程开启完毕!");

    }
}
