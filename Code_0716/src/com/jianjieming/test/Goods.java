package com.jianjieming.test;

/**
 * 商品类
 * @author 铭
 */
public class Goods {

    static {
        /*
            我就是静态代码块.
            我是属于类的一个成员,会随着类的加载而执行.
            因为类只加载一次,所以我也只执行一次.
            我会做一些类的初始化工作.
            可以有多个静态代码块.
            多个静态代码块之间,一般会根据书写顺序,顺序执行.
         */
        System.out.println("静态代码块执行了");
    }

    {
        /*
            我是代码块.
            我是属于对象的,会随着对象的加载而执行.
            先于构造方法执行.
            创建几个对象执行几次.和书写顺序无关.
         */
        System.out.println("代码块1");
    }


    private String name;
    private float price;
    private int quantity;

    public Goods(String name, float price, int quantity) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Goods(String name, float price) {
//        this.name = name;
//        this.price = price;
//        this.quantity = 1;
        this(name,price,1);
    }

    {
        System.out.println("代码块2");
    }

    /*

        内部类:
            在某个类的内部声明的类就叫做内部类.

     */

}
