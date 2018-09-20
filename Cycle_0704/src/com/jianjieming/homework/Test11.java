package com.jianjieming.homework;

public class Test11 {
    public static void main(String[] args) {
//        斐波那契数列
//        1 1 2 3 5 8 13 21 34 55 89
//        f(n) = f(n-2) + f(n-1)
//        f(0) = 1; f(1) = 1;

        int one = 1;
        int two = 1;

//        int n1 = one = two;
//        one = two;
//        two = n1;
//        int n2 = one + two;
//        one = two;
//        two = n2;
//        int n3 = one + two;
//        System.out.print(n1 + "," + n2 + "," + n3);
        System.out.print(one + " ");
        System.out.print(two + " ");

        for (int i = 0; i < 20; i++) {
            int num = one + two;
            one = two;
            two = num;
            System.out.print(num + " ");
        }
    }
}
