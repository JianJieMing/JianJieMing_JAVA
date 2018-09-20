package com.jianjieming;

public class Test03 {
    public static void main(String[] args) {
//        练习: 判断一个变量n是不是1到10之间的数
//        思路: 判断变量n是不是大于等于1 并且 小于等于10
        int n = 4;
        boolean result = n >= 1 && n <= 10;
//        判断一个数 是不是3和5的倍数
//        判断变量a能不能同时被3和5整除
//        a对3求余是不是等于0 并且 对5取余是不是也等于0
        int a = 5;
        boolean b = a % 3 == 0 && n % 5 == 0;

//        &
        int x = 14, y = 26, z;
        z = x & y;
        System.out.println(z);
        System.out.println(x / y);
        /*
        0000 1110 14
        0001 1010 26
        ---------------
        0000 1010 & 10
        0001 1110 / 30
        ---------------
        0001 0100 ^ 20
         */

        System.out.println(x << 2);
//        0000 1110 14 左移两位代表 14 * 2²
//        0011 1000 56

//        如何最高效率的判断一个变量是不是偶数
//        15    0000 1111
//              0000 0111 >>1
//              0000 1110 <<1
        System.out.println(x == x >> 1 << 1);

//        练习: 不使用第三个变量,交换两个变量的值
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x);
        System.out.println(y);
    }
}
