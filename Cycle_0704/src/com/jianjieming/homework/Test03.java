package com.jianjieming.homework;

public class Test03 {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 100; i < 1000; i++) {
            a = i / 100;// 得1
            b = i % 100 / 10;// 得0
            c = i % 10;// 得0
            d = (a * a * a) + (b * b * b) + (c * c * c);
            if (i == d){
                System.out.println(d + "是水仙花数");
            }
        }
    }
}
