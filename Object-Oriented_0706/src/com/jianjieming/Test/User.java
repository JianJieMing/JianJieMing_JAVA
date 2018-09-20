package com.jianjieming.Test;

import java.util.Random;
import java.util.Scanner;

public class User {
    /**
     * 用户登录
     */
    public int password = 123456;
    public int money = 0;
    public int card10 = 10, card20 = 7, card50 = 5, card100 = 3;
    public boolean flag = true;

    //        生成六位随机数

    public void dl() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int a = 0;
        for (int j = 0; j < 1; j++) {
            a = (int) ((Math.random() * 9 + 1) * 100000);
        }
        System.out.println("你的初始卡号为: " + a);
        System.out.println("你的初始密码为: " + password);
        System.out.println("------------------");
        System.out.println("请输入卡号: ");
        int cardNumber = scanner.nextInt();
        System.out.println("请输入密码: ");
        int password2 = scanner.nextInt();
        if (cardNumber == a && password2 == password) {
            System.out.println("登陆成功");
            System.out.println("当前余额为: " + money + "元");

            while (true) {
                System.out.println("输入1充值,输入2退出: ");
                int c = scanner.nextInt();
                if (c == 1) {
                    System.out.println("充值卡: 1: 10元, 2: 20元, 3: 50元, 4: 100元");
                    System.out.println("选择需要充值的充值卡: ");
                    int ss = scanner.nextInt();
                    if (ss == 1 && card10 != 0) {
                        money = money + 10;
                        card10 = card50 - 1;
                        System.out.println("充值成功,余额为: " + money);
                        if (card10 == 0) {
                            System.out.println("充值卡已用完,自动补充完毕!");
                            card10 = card10 + 20;
                            System.out.println("充值卡剩余: " + card10);
                        }
                    } else if (ss == 2 && card20 != 0) {
                        money = money + 20;
                        card20 = card20 - 1;
                        System.out.println("充值成功,余额为: " + money);
                        if (card20 == 0) {
                            System.out.println("充值卡已用完,自动补充完毕!");
                            card20 = card20 + 20;
                            System.out.println("充值卡剩余: " + card20);
                        }
                    } else if (ss == 3 && card50 != 0) {
                        money = money + 50;
                        card50 = card50 - 1;
                        System.out.println("充值成功,余额为: " + money);
                        if (card50 == 0) {
                            System.out.println("充值卡已用完,自动补充完毕!");
                            card50 = card50 + 15;
                            System.out.println("充值卡剩余: " + card50);
                        }
                    } else if (ss == 4 && card100 != 0) {
                        money = money + 100;
                        card100 = card100 - 1;
                        System.out.println("充值成功,余额为: " + money);
                        if (card100 == 0) {
                            System.out.println("充值卡已用完,自动补充完毕!");
                            card100 = card100 + 50;
                            System.out.println("充值卡剩余: " + card100);
                        }
                    }
                } else if (c == 2) {
                    System.out.println("退出成功");
                    break;
                }
            }
        }

    }
}
