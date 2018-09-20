package com.jianjieming.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
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

        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }

        for (int i = newArr.length - 1; i >= index; i--) {
            newArr[i] = newArr[i - 1];
        }
        newArr[index] = n;
        System.out.println(Arrays.toString(newArr));


    }
}
