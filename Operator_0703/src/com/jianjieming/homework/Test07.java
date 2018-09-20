package com.jianjieming.homework;

public class Test07 {
    public static void main(String[] args) {
        int a = 1, b = 10;
        System.out.println("交换前" + a + "    " + b);

        a = a + b;// a = 11
        b = a - b;// b = 1
        a = a - b;// a = 10

        System.out.println("交换后" + a + "    " + b);


        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换后" + a + "    " + b);

    }
}
