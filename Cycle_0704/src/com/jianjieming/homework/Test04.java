//package com.jianjieming.homework;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Test04 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
////  有一组学员的成绩{99,85,82,63,60},将它们按降序排 序,保存在一个数组中,
////  现需要增加一个学员的成绩, 将它插入到数字中,并保持成绩降序排序
//
//        int[] arr2 = {99, 85, 82, 63, 60};
//        int[] arr1 = new int[arr2.length + 1];
//
//        System.out.println("请输入一个数字: ");
//        arr1[5] = scanner.nextInt();
//
//        int a = 0;
//
//        for (int i = 0; i < arr2.length; i++) {
//            if (arr1[5] < arr2[i]){
//                a = i;
//                break;
//            }
//        }
//
//
//        for (int i = 0; i < arr1.length; i++) {
//            if (i > a){
//                if (i == a){
//                    arr2[i] = arr1[5];
//                }
//                if (a+1<arr2.length){
//                    arr2[i+1] = arr1[i];
//                }
//            }
//
//            {
//                arr1[i] = arr2[i];
//            }
////            for (int i1 = 0; i1 < arr1.length; i1++) {
////                arr1[i1] = arr2[i];
////                arr1[i1] = scanner.nextInt();
////                System.out.println(arr1[i1]);
////            }
//            System.out.println(arr1[i]);
//        }
//    }
//}
