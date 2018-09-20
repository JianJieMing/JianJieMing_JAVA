package com.jianjieming.homework;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要托运行李的重量");
        int a = scanner.nextInt();
        double b = 50 * 0.15;
        if (a <= 50) {
            System.out.println("本次邮费需要: " + a * 0.15 + "元");
        } else if (a > 50) {
            a = a - 50;
            System.out.println("本次行李超出"+ a + "公斤" + "\n" + "总需要" + (a * 0.25 + b) + "元");
        }
    }
}
