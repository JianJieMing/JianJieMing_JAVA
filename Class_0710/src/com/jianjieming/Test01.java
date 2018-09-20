package com.jianjieming;

import java.util.Scanner;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎光临! 输入1登录2注册: ");
        int ss = scanner.nextInt();
        String a1;
        String a2;
        while (true) {
            if (ss == 2) {
                System.out.println("请输入用户名: ");
                String username = scanner.nextLine();
                a1 = username;
                System.out.println("请输入密码: ");
                String password = scanner.nextLine();
                a2 = password;
                if (password.length() < 8) {
                    System.out.println("密码长度不够8位");
                    continue;
                }
                for (int i = 0; i < 10; i++) {
                    String s = String.valueOf(i);
                    if (password.startsWith(s)) {
                        System.out.println("密码不能以数字开头");
                        continue;
                    }
                }
                System.out.println("注册成功!");
                break;
            }
        }
        if (ss == 1) {
            System.out.println("请输入用户名: ");
            String username2 = scanner.nextLine();
            System.out.println("请输入密码: ");
            String password2 = scanner.nextLine();
            if (a1.equals(username2) && a2.equals(password2)) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或者密码错误");
            }
        }
    }
}
