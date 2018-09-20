package com.jianjieming.Test;

public class Test02 {
    public static void main(String[] args) {
//        int n = 5;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= 2 * i - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        System.out.println("----------------");
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n - i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }


        /**
         * 二维数组:
         * 可以看做每个元素都是一个一位数组的一推数组.
         */
        int[][] array = new int[3][4];
        array[0][0] = 5;
        System.out.println(array[0]);
        array[0] = new int[5];
    }
}
