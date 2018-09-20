package com.jianjieming.study;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class SyncDemo {

    private static List<Integer> data = new ArrayList<>();

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        /*
            1. 把线程不安全的集合转换为线程安全的.
         */
//        List<Integer> integers = Collections.synchronizedList(data);
        /*
            2. 直接使用线程安全的集合对象.
               Vector 本身就是线程安全的.
//             Hashtable是线程安全的Map.  map也叫做字典.

         */
//        data = new Vector<>();
        /*
            3. 同步代码块,同一时间只能允许一个线程访问.
            private static Object lock = new Object();
                synchronized (lock) {
                        data.add(j);
                    }
         */


        /*
            开启五条线程.
            每条线程都向集合中放入100个数.
            总计500个.
         */
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    synchronized (lock) {
//                保证同时只能有一个线程访问该代码.
                        data.add(j);
                    }
                }
            }).start();
        }

//        主线程停1秒,为了保障上面五条线程都能执行完.
        Thread.sleep(1000);
        System.out.println(data.size());

        /*
            1. 程序正常执行,输出结果为500.
            2. 程序正常执行,输出结果小于500.
            3. 抛出下标越界异常.
         */

        Waiter w = new Waiter();

        /*
            同步的成员方法的锁是当前类的对象.
            同步的静态方法的锁是当前的类.
         */

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    w.doSth();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(w.getIndex());

    }
}
