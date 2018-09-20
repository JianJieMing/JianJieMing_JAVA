package com.jianjieming.Test;

public class Test03 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入: ");
//        int a = scanner.nextInt();

        int n = 2;
        int j;

        for (j = 2; j < n / 2; j++) {
            if (n % j == 0) {
                break;
            }
        }
        if (j >= n / 2) {
            System.out.println("质数");
        } else {
            System.out.println("合数");
        }
    }
}

