package com.jianjieming.Test;

import java.util.Arrays;

public class Test05 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 5, 8, 7, 2, 4, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int time;
                    time = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = time;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
