package com.jianjieming;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
            字符串
            字符串是通过封装char而得到的.

         */

        String str = "我于杀戮之中绽放,犹如黎明中的花朵.";

        String str2 = "   我是2都s.ghjAA不.3睡觉是ss.s看4房,是该粉   1红色,AAGYU.说过年32后,讲话稿.为4佛   的有一个5人,是尼佛杀12刚回东 ";

//        1. 获取字符串的长度.
        int length = str.length();

//        2. 获取字符串中第几个字符.
        char c = str.charAt(2);
        System.err.println(c);

//        3. 获取某个字符在字符串中第一次出现的位置.
        int index = str.indexOf('花');
        System.err.println(index);

        /*
            方法的重载:
                在同一个类中,存在多个方法,这几个方法满足下述的规则:
                    1. 方法名相同.
                    2. 参数列表不同.
                       2.1 参数个数不同.
                       2.2 参数类型不同.
                       2.3 参数顺序不同.
                实际上的原则: 当调用的时候,可以明确区分调用的是哪一个即可.
         */

//        3. 查询第二个花在字符串中的位置.如果没有结果会输出-1.
        int index2 = str.indexOf("花", 16);
        System.err.println(index2);

//        4. 查字符串中某个子串的位置.
        int index3 = str.indexOf("杀戮");
        System.err.println(index3);


        int index4 = str.indexOf("杀戮", index + 1);
        System.err.println(index4);

//        5. 判断字符串是否包含某个字符.
        boolean isContains = str.contains("绽放");
        System.err.println(isContains);

//        6. 判断一个字符串是不是以什么开始的.
        boolean isStartWith = str.startsWith("我");
        System.err.println(isStartWith);

//        7. 判断一个字符串是不是以什么结束的.
        boolean isEndWith = str.endsWith("花朵.");
        System.err.println(isEndWith);

//        8. 检索某一个字符,在字符串中最后出现的位置.
        int a1 = str.lastIndexOf("色");

//        9. 将字符串中的某个字符都替换为新的字符.(原字符串对象没有变化,该方法会返回一个新的字符串对象.)
        String a = str2.replace('是', '否');
        System.err.println(a);

        String b = str2.replace("红色", "蓝色");
        System.err.println(b);

//        10. 把满足正则表达式的字符串都替换为某个字符串.
        String s2 = str2.replaceAll("\\d", "AB");
        System.err.println(s2);

//        11. 判断字符串是否为空.(根据字符串长度判断是否为空,看源码.)
        String l; // 只声明了,没有值,不能用.
        String ll = null; // 空指针异常.
        String lll = ""; // true.
        String llll = " "; // false.
        boolean s3 = str.isEmpty();
        System.err.println(s3);

//        12. 字符串的截取[beginIndex, endIndex],包含第一个字符,不包含最后一个字符.
        String ss = str.substring(0, 8);
        System.err.println(ss);

//        13. 把字符串中的英文转换为小写字母.
        String ss1 = str2.toLowerCase();
        System.err.println(ss1);

//        14. 把字符串中的英文转换为大写字母.
        String ss2 = str2.toUpperCase();
        System.err.println(ss2);

//        15. 去掉字符串的首尾所有空格.
        String trim = str2.trim();
        System.err.println(trim);

//        16. 把字符串转换为字节数据.
        byte[] bytes = str2.getBytes();

//        17. 把字符串转换为字符数组.
        char[] chars = str2.toCharArray();

//        18. 根据正则表达式把字符串分割为字符串的数组.(正则表达式.代表任意字符,需要\\转意)
        String[] strings = str2.split("\\.");
        System.err.println(Arrays.toString(strings));

//        19. 判断两个字符串是否一样(看源码)
        boolean isEquals = str2.equals("固定卡萨");

//        20. 忽略大小写判断两个字符串是否一样.(比如判断验证码)
        String ss4 = "hello";
        String ss5 = "hello";
        boolean ss6 = ss4.equalsIgnoreCase(ss5);
        System.err.println(ss6);


    }
}
