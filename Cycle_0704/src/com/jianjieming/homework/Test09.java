package com.jianjieming.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {50, 88, 66, 32, 77};
        System.out.println("请输入需要插入的数: ");
        int n = scanner.nextInt();
        boolean flag = true;
        int index = 0;
//        对原数组排序
        Arrays.sort(array);
        int[] newArr = new int[array.length + 1];

//        首先找到新值n应该插入哪个位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= n) {
                index = i;
                break;
            }
        }

        if (n >= array[array.length - 1]) {
            index = array.length;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = array[i];
            } else if (i == index) {
                newArr[i] = n;
            } else {
                newArr[i] = array[i - 1];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
