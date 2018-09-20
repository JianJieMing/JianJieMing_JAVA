package com.jianjieming.homework;

import java.util.Arrays;

public class Test13 {
    public static void main(String[] args) {
//        确定循环次数,找下标规律
        int[] array = {1, 3, 2, 8, 4, 7, 5, 6};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i] < array[j]) {
                    int time;
                    time = array[i];
                    array[i] = array[j];
                    array[j] = time;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
