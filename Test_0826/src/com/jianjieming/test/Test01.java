package com.jianjieming.test;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
