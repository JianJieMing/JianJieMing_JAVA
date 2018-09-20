package com.jianjieming.homework;

public class Test06 {
    public static void main(String[] args) {
//        阶乘定义: f(n) = n * f(n - 1)
        int a = 5;
        int b = 1;
        for (int i = 1; i <= 5; i++) {
            b = b * i;
        }
        System.out.println("5的阶乘为" + b);
    }
}
