package com.jianjieming.homework;

public class Test05 {
    public static void main(String[] args) {
        double a = 8848130;
        double b = 0.08;
        int c = 0;
        while (b < a) {
            c++;
            b = b * 2;
        }
        System.out.println("折叠" + c + "次就可以超过珠穆朗玛峰");
    }
}
