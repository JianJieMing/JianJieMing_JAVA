package com.jianjieming.homework;

public class Test03 {
    public static void main(String[] args) {
//        第一种写法
        int a = 11;
        System.out.println(a == a >> 1 << 1);

        if (a >>1 <<1 == a){
            System.out.println("是偶数");
        } else {
            System.out.println("是奇数");
        }

//        第二种写法
        int b = 13;
        if (b % 2 == 0) {
            System.out.println("是偶数");
        } else {
            System.out.println("是奇数");
        }
    }
}
