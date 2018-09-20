package com.jianjieming;

public class ForDemo {
    public static void main(String[] args) {
        /**
         *break 遇到break,循环会直接停止.
         *
         * continue 遇到continue,会停止当前的循环,直接进行下次循环.
         */

//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 1){
//                continue;
//            }
//            System.out.println(i);
//        }

        /**
         * 循环嵌套
         */

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " " + j);
            }
        }

    }
}
