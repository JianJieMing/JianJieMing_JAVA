package com.jianjieming.homework;

import java.util.Arrays;

public class Test14 {
    public static void main(String[] args) {
        // 将27和44的位置调换
        int[] array = {13, 22, 33, 44, 52, 62, 27};

        for (int i = 0; i < array.length - 1; i++) {
//            下标i 和 下标i+1 比 就是第一个数和第二是数比
            if (array[i] > array[i + 1]){
                int temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
