package com.jianjieming;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入猪脚名字");
        String a = scanner.nextLine();
        switch (a){
            case "佐助":
                System.out.println("火影忍者");
                break;
            case "金木":
                System.out.println("东京喰种");
                break;
            case "路飞":
                System.out.println("海贼王");
                break;
            default:
                System.out.println("给你推荐个网站: www.baidu.com");
                break;
        }
    }
}
