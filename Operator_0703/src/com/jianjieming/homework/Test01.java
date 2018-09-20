package com.jianjieming.homework;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的金额:");
        int money = scanner.nextInt();
        int money100 = money / 100;
        money = money % 100;
        int money50 = money / 50;
        money = money % 50;
        int money20 = money / 20;
        money = money % 20;
        int money10 = money / 10;
        money = money % 10;
        int money5 = money / 5;
        money = money % 5;

        System.out.println("由" + money100 + "张100元," + money50 + "张50元,"
                + money20 + "张20元," + money10 + "张10元," + money5 + "张5元,"
                + money + "张一元组成.");
    }
}
