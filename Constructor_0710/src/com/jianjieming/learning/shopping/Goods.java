package com.jianjieming.learning.shopping;

/**
 * 商品类
 *
 * @author 铭
 */
public class Goods {
    private String name;
    private float price;
    public static int index = 0;

    /*

        构造方法是一个特殊的方法,没有返回值类型,方法名和类名相同.
        如果一个类中没有构造方法,那么会有一个隐藏的默认的构造方法.

        创建对象的时候会调用构造方法.
        如果类中定义了带参数的构造方法,那么默认的构造方法就会消失.
        如果必须要用默认的构造方法.就自己写一个无参的构造方法.
        构造方法是可以重载的.

     */

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

//    public Goods() {
//
//    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void price(){

    }

    public static void test(){
        Goods goods = new Goods("d",2);
        goods.price();
    }



}
