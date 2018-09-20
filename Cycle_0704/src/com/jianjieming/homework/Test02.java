package com.jianjieming.homework;

public class Test02 {
    public static void main(String[] args) {
//        1. 有10亿元，每天花一半，可以花多少天,打印天数
        int a = 1000000000;
        int time = 0;
        while (a > 0){
            time++;
            a = a / 2;
        }
        System.out.println(time);
    }
}
