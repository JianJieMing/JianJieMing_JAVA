package com.jianjieming.test;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
//        由键盘输入5个整数,求和
        int sum = 0;
        Scanner scanner0 = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "数字: ");
            try {
                int a = scanner0.nextInt();
                sum = sum + a;
            } catch (InputMismatchException e) {
                System.out.println("输入错误,请重新输入数字: ");
                i--;
                scanner0 = new Scanner(System.in);
            }
        }
        System.out.println("和为: " + sum);
    }
}
