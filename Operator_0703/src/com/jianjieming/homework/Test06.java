package com.jianjieming.homework;

public class Test06 {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int c = 1;

        int max1 = a > b ? a : b;
        int max2 = max1 > c ? max1 : c;
        System.out.println(max2);
    }
}
