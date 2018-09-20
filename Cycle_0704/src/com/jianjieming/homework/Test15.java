package com.jianjieming.homework;

public class Test15 {
    public static void main(String[] args) {
        /**
         * 5块钱1只公鸡, 3块钱一只母鸡, 3只雏鸡1块钱.
         * 现在花了100块钱买了100只鸡, 计算出公鸡/母鸡/雏鸡的数量.
         */
        int a = 20;// 公鸡
        int b = 33;// 母鸡
        int c = 300;// 小鸡

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k += 3) {
                    if (i + j + k == 100 && 5 * i + 3 * j + k / 3 == 100) {
                        System.out.printf("公鸡: %s只, 母鸡: %s只, 雏鸡: %s只\n", i, j, k);
                    }
                }
            }
        }

    }
}
