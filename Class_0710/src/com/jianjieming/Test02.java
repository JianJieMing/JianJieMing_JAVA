package com.jianjieming;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {
        /*
            随机数
         */
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            System.out.print(random.nextInt(9)+1);
//        }
        /*
            日期类
            单例模式 / 静态工厂  23种设计模式之一
         */
//        Calendar calendar = Calendar.getInstance();

//        获取日期相关的数据.
//        int i = calendar.get(Calendar.YEAR);
//        System.out.println(i);

//        日期计算,给日期中的某个属性加某个值.
//        calendar.add(Calendar.YEAR, 5);
//        calendar.set(1996,9,20);
//        int i1 = calendar.get(calendar.DAY_OF_YEAR);
//        System.out.println(i1);

        /*
            正则表达式
            作用:
                1. 用来判断字符串是不是符合某个规则.
                2. 在某个字符串中查找某个规则的字符串.
         */

        String str = "aoofhuhaooo* apg opp*;pf/aip?*oo1of`aoo!of$*ajsiaooo]ooodfgbuafj";
//        正则表达式中的加号+,表示匹配前面的字符1个或多个.
        String[] split = str.split("ao+");
        System.out.println(split.length);
        String[] split1 = str.split("ao*");
        System.out.println(Arrays.toString(split1));
//        | 代表或 [] 代表匹配一个字符,匹配规则为[]里面的任意一个.
        String[] split2 = str.split("[*?$]+");
        System.out.println(Arrays.toString(split2));

        String email = "abcd123@163.com";
        String rex = "[\\d\\w]{6,}+@[a-zA-Z0-9]+\\.com";
//        判断正则表达式和字符串是否符合要求.
        System.out.println(email.matches(rex));
//        \\s 匹配所有空白 包括空格/换行/制表符 | /n/t/r
//        \\w 英文/数字/下划线_

//        判断正则表达式和字符串是否符合要求的第二种方式.
        boolean matches = Pattern.matches(rex, email);

        /*
            基本数据类型的包装类.
         */
        int a = 5;
        Integer n = 5;
        int anInt = Integer.parseInt("12345");
        System.out.println(anInt);
        Character c = '龍';

        Integer a1 = 100;
        Integer a2 = 100;
        Integer b1 = 200;
        Integer b2 = 200;

//        记得看源码 -128 127
        Integer b3 = Integer.valueOf(200);

        System.out.println(a1 == a2);
        System.out.println(b1 == b2);

        String ss = "name=zhangsan,age=15,height=1.8,name=李四,age=20,height=1.6,name=王五,age=21,height=1.9";

//        创建三个Person对象,再把三个Person对象存到数组里.

    }
}
