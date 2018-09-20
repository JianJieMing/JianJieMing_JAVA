package com.jianjieming.homework;

import java.util.Arrays;

public class Test12 {
    public static void main(String[] args) {
        int[] arr = {42, 56, 22, 34, 76, 64};

/*
        将数组镜像 反过来.
        42  64
        56  76
        22  43
*/

//            循环三次所以数组长度除以2
        for (int i = 0; i < arr.length / 2; i++) {
//            System.out.println(i + "" + (arr.length-1-i));
//            定义两个变量 a a2
            int a = i;
            int a2 = arr.length - 1 - i;//
            int temp = arr[a];
            arr[a] = arr[a2];
            arr[a2] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
