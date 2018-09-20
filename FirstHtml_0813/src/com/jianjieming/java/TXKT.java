package com.jianjieming.java;

/**
 * @author 铭
 */
public class TXKT {
    public static void main(String[] args) {
        String s = "aaa";
        String s2 = new String("aaa");// 只要看到new关键字,就在堆里
        String s3 = "AAA";
        String s4 = new String("aaa");
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s2 == s4);

        /*
            内存的角度出发,一共分为4个步骤 4 jdk String.class
            1. String.class的文件存在于硬盘上,通过ClassLoader.load(类加载器)
               把文件从硬盘上读取到JVM中加载到类缓存区.
            2. 在栈中定义了s的变量.
            3. 在常量池中定义了数据aaa.
            4. 根据运算符把它们关联到一起.


         */
    }
}
