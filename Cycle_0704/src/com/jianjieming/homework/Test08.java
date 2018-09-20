package com.jianjieming.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {50, 88, 66, 32, 77};
        System.out.println("请输入需要插入的数: ");
        int n = scanner.nextInt();
        boolean flag = true;
//        对原数组排序
        Arrays.sort(array);
        int[] newArr = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < n) {
                newArr[i] = array[i];
            } else {
                if (flag) {
                    newArr[i] = n;
                    flag = false;
                }
                newArr[i + 1] = array[i];
            }
        }
        if (n >= array[array.length - 1]) {
            newArr[newArr.length - 1] = n;
        }
//        不用遍历输出数组
        System.out.println(Arrays.toString(newArr));
    }
}
