package com.jianjieming.homework;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = 0;
        int f = 0;
        int g = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                if (i == 1) {
                    System.out.println("请输入1班同学成绩: ");
                    int oneClass = scanner.nextInt();
                    d = d + oneClass;
                }
                if (i == 2) {
                    System.out.println("请输入2班同学成绩: ");
                    int twoClass = scanner.nextInt();
                    f = f + twoClass;
                }
                if (i == 3) {
                    System.out.println("请输入3班同学成绩: ");
                    int threeClass = scanner.nextInt();
                    g = g + threeClass;
                }
            }
        }
        System.out.println("1班总分为:" + d);
        System.out.println("1班的平均分为:" + d / 4);
        System.out.println("2班总分为:" + f);
        System.out.println("2班的平均分为:" + f / 4);
        System.out.println("3班总分为:" + g);
        System.out.println("3班的平均分为:" + g / 4);
    }
}
