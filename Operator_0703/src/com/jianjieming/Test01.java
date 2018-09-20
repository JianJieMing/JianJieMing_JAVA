package com.jianjieming;

public class Test01 {
    public static void main (String[] args){
        int a = 10;
        byte b = 10;
        b = (byte) (b + a);

        String s = "hello";
        System.out.println(s + 1 + 2);
        System.out.println(1 + 2 + s);

        int i = 10;
        int r = i++ * ++i - i++ + ++i;
        // 10 * 12 - 12 + 14

        System.out.println(i);

        // 转换成小写
        char x = 'A';
        x += 32;
        System.out.println(x);
        // 交换两个变量的值,不定义第三个变量
        int w = 5;
        int e = 10;
        w = w + e;
        e = w - e;
        w = w - b;
        System.out.println(w);
        System.out.println(e);
        // 坏处是数值过大,可能会超出范围,结果不准确
    }
}
