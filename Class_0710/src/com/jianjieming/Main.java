package com.jianjieming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {

        /*

            常用类:
                1. 可变字符串

            在多线程情况下,优先使用StringBuffer,因为是线程安全的.

            单线程情况下,优先使用StringBuilder,因为它的效率比StringBuffer要高.

            用法它俩一模一样.


            常用类2:
                Math 这个类提供了一些常用的数学计算方法,是一个工具类.

            常用类3:
                时间日期相关

         */

        StringBuffer sb = new StringBuffer();
//        StringBuilder sb = new StringBuilder("初始");

        String[] strings = {"A", "B", "C", "D", "E"};
        for (int i = 1; i < strings.length; i++) {
//            1. append 字符串拼接
            sb.append(i).append(strings[i]);
        }
//        2. 截取是有返回值的,也不会对原来的造成更改.
        String substring = sb.substring(2);

//        3. toString 把StringBuilder对象转换为String
        String str = sb.toString();

//        4. 把从[start,end]部分的字符串替换成str
        sb.replace(1, 3, "java");

//        5. 把字符串翻转
        sb.reverse();

//        6. 在某个位置插入某个值
        sb.insert(3, 2000);


        System.out.println(str);

//        计算绝对值
//        Math.abs();
//        返回一个[0,1]由零到一随机数
        double random = Math.random();
//        获取一个从1到100的一个整数
        int ran = (int) (Math.random() * 100 + 1);
        System.out.println(ran);

        long l = System.currentTimeMillis();
        System.out.println(l);
        Date date = new Date(0);
        Date date2 = new Date(l + 100000);
//        判断两个时间的关系
        System.out.println(date.after(date2));
//        date.getTime();

//        时间格式化
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        System.out.println(df.format(date));

        String f = "1996年10月20日";
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Date parse = format.parse(f);
            System.out.println(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
