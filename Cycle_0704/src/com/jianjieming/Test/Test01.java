package com.jianjieming.Test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < 4; i++) {
//            System.out.println("请输入学生成绩: ");
//            int[] arr = scanner.nextInt();
//        }
//        int[] arr = {results1, results2, results3, results4};
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.prinln(a[i]);
//        }

//        有3个班级,每个班级有4名学员参赛,又如何计算每个班级的平均分呢?




        int d = 0;
        int f = 0;
        int g = 0;
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


/*
        十进制转换为二进制 337

        512 256 128 64 32 16 8 4 2 1
         0   1   0   1  0  1 0 0 0 1

*/

    }
}
