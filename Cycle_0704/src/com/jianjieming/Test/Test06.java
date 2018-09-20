package com.jianjieming.Test;

public class Test06 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 5, 6, 7, 1, 7, 5};
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x ^= arr[i];
        }
        System.out.println(x);
    }
}
