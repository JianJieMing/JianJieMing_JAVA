package com.jianjieming.homework;

public class Test01 {
    public static void main(String[] args) {
        String s = "都是啊奇偶发送到安徽啊分行奥电脑哦啊吧";

        char b = '啊';

        for (int i1 = 0; i1 < s.length(); i1++) {
            if (b == s.charAt(i1))
                System.out.println(i1);
        }
//        第二种写法
        int i = -1;
        do {
            i = s.indexOf(b, i + 1);
            if (i == -1) break;
            System.out.println(i);
        } while (true);


    }
}
