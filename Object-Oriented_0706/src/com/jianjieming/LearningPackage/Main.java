package com.jianjieming.LearningPackage;
// 声明该类所在的包,规定必须在第一行.

public class Main {
    public static void main(String[] args) {
/*

        创建顾客类Consumer的对象
        创建对象的格式:
            数据类型 变量名 = 初始值;
        新建个类就相当于新建了一个新的引用数据类型.

        新建Consumer类的Collect money对象,对象名为consumer
        创建对象的公式:
            类名 变量名 = new 类名();

        一般情况下,某个类可以创建多个对象.
       通过对象名.属性名 的方式调用某个对象的属性.
       某个类中的所有对象,相互都是独立的.
       改变其中一个对象的状态时,不会对其他对象产生影响.
       当一个对象创建好之后,会把该对象的所有属性都划分好内存.
       对象中的属性都是有初始值的.

       整数型默认值: 0
       浮点型默认值: 0.0
       boolean型默认值: false
       char默认值: 数字0在ASCII码中对应的字符.
       引用数据类型默认值: null

       一个创建对象的过程:
            1.声明变量名.
            2.堆内存中划分内存空间.
            3.在内存空间中给初始值(对对象的初始化).


        遇到的第三个异常: 空指针异常
            调用了某个值为null的,对象的方法或者属性时,会抛出空指针异常.

*/

        Goods goods1 = new Goods("手机", 1999);

        Consumer consumer = new Consumer("李四");
        consumer.add(goods1);
        consumer.buy();


    }
}
