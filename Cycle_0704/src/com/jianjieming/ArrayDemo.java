package com.jianjieming;

import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        用户输入五次成绩,输出最高的成绩.
//        int max = 0;
//        for (int i = 0; i < 5; i++) {
//            System.out.println("请输入你的成绩");
//            int a = scanner.nextInt();
//            if (a > max){
//                max = a;
//            }
//        }
//        System.out.println("最大值是: " + max);


//        int[] arr = {99,85,82,63,60};
//        for (int i = 0; i < arr.length; i++) {
//
//        }


//
//        float[] a = new float [10];
//        System.out.println(a[3]);


//        int[] arr = {1,2,3,4,5};
//        System.out.println(arr[arr.length-1]);

//        int i = 0;
//        int a = 0;
//        while (i < 100) {
//            i++;
//            a = a + i;
//            if (i % 2 == 0) {
//                a = a + i;
//            }
//        }
//        System.out.println(a);


//        获取出数组中最大的数,最小的数,平均值
//        int[] arr = {1, 4, 6, 2, 3, 5};
//        int max = arr[0];
//        int min = arr[0];
//        float avg;
//        int sum = 0;
//        int a = 0;
//        int b = 0;

//        for (int i = 0; i < arr.length+1; i++) {
//            if (i > max){
//                max = i;
//            }
//        }
//        System.out.println(max);

//        while (arr.length > a) {
//            max = max > arr[a] ? max : arr[a];
//            sum += arr[a];
//            a++;
//        }
//        System.out.println("最大值为: " + max);
//
//        while (arr.length > a) {
//            min = min < arr[a] ? min : arr[a];
//            a++;
//        }
//        System.out.println("最小值为: " + min);
//
//        avg = sum * 1.0F / arr.length;
//        System.out.println("和为: " + sum);
//        System.out.println("平均值为: " + avg);

//        获取出数组中最大的数,最小的数,平均值
//        int[] arr = {1, 4, 6, 3, 5, 2};
//        int max = arr[0];
//        int min = arr[0];
//        int num = 0;
//        double avg;
//        for (int i = 0; i < arr.length; i++) {
//            max = max > arr[i] ? max : arr[i];
//            min = min < arr[i] ? min : arr[i];
//            num += arr[i];
//        }
//        avg = num * 1.0 / arr.length;
//
//        System.out.println("最大值" + max);
//        System.out.println("最小值" + min);
//        System.out.println("和" + num);
//        System.out.println("平均值" + avg);


//        100 血量的怪 每次攻击13血 打多少次可以打死
        int health = 1000;
        int times = 0;

        System.out.println("全体集合,去杀大龙!!!");
        while (health > 0) {
            System.out.println("请输入你需要打出的伤害");
            int attack = scanner.nextInt();
            times++;
            if (times % 5 == 0){
                System.out.println("***暴击***");
                health -= attack * 2;
            } else {
            health = health - attack;
            }
            System.out.println("男爵还剩: " + health + "血");
        }
        System.out.println("恭喜你砍了" + times + "刀,击杀了男爵!!!");
    }
}
