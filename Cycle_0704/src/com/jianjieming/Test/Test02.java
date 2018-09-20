package com.jianjieming.Test;

public class Test02 {
    public static void main(String[] args) {
        /**
         * 外层循环控制行数
         * 内存循环控制个数
         */
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
