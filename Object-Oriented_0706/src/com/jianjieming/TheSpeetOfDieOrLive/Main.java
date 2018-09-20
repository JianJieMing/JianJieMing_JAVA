package com.jianjieming.TheSpeetOfDieOrLive;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("系统:欢迎来到The speed of die or live!");
        System.out.println("系统:挑战者呀,请留下你的名字:");
        String playerName = scanner.nextLine();
//        ThePlayer thePlayer = new ThePlayer();
//            thePlayer.arr[0] = playerName;
        System.out.println("系统: " + playerName + "请做好准备,5秒后开始你的挑战");
        for (int i = 0; i <= 5; i++) {
            if (i == 1) {
                Thread.sleep(1000);
                System.out.println(5);
            } else if (i == 2) {
                Thread.sleep(1000);
                System.out.println(4);
            } else if (i == 3) {
                Thread.sleep(1000);
                System.out.println(3);
            } else if (i == 4) {
                Thread.sleep(1000);
                System.out.println(2);
            } else if (i == 5) {
                System.out.println(1);
                Thread.sleep(1000);
            }
        }
        System.out.println("游戏开始!!!");

        CustomsPass customsPass1 = new CustomsPass();

        customsPass1.initial();

    }
}
