package com.jianjieming.homework;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查询的年份,友情提醒2004是闰年哦");
        int a = scanner.nextInt();
        if (a%4 == 0 && a%100 != 0 || a%400 == 0){
            System.out.println(a + "年是闰年");
        } else {
            System.out.println("不是闰年");
        }
    }
}
