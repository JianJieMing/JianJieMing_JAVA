package com.jianjieming.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class Test01 {

    private static final List<Integer> list = new ArrayList<>();
    private static final Object o = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (o) {
                    for (int i1 = 0; i1 < 100; i1++) {
                        list.add(i1);
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
            System.out.println(list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
