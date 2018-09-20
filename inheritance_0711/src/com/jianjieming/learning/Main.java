package com.jianjieming.learning;

import com.jianjieming.learning.zoo.Animal;
import com.jianjieming.learning.zoo.Feeder;
import com.jianjieming.learning.zoo.Mouse;
import com.jianjieming.learning.zoo.Penguin;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Penguin penguin = new Penguin("QQ", 1001);
        Mouse mouse = new Mouse("米老鼠", 666);

        penguin.eat();
        penguin.sleep();
        penguin.introduction();
        penguin.catchFish();

//        mouse.setName("东北老鼠");
        mouse.eat();
        mouse.sleep();
        mouse.introduction();
        mouse.StealingOil();
        /*
            final关键字:
                它可以修饰类/方法/属性.
                如果修饰的是类,那么该类不能被继承.
                修饰方法,那么该方法不能被重写(覆写).
                修饰属性,那么该属性的值,不能被改变.
         */

        Animal a1 = new Animal("蛤蟆", 1);
        Animal a2 = new Animal("蛤蟆", 1);
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        /*
            直接打印一个对象的时候,实际上在打印该对象的toString()方法的返回值.
            那么我可以重写该方法,自定义打印的内容.
         */
        System.out.println(a1);

        System.out.println("**********************");

        penguin.eat();
        mouse.eat();

        /*
            多态的原则:
                当调用某个对象的某个方法时,
                系统会看这个对象的真实类型是什么,
                调用的永远都是这个真实对象的方法.

                多态的表现形式:
                    1. 父类声明对象 由子类初始化(创建对象).
                    2. 如果一个方法的参数中,需要传递某个类型的参数,
                       那么该类型的子类对象都可以进行传递.
                    3. 如果一个方法的返回值是某个类型,
                       那么该类型的所有子类对象都可以作为返回值.
         */
//      1.
        Animal animal1 = new Penguin("企鹅", 1003);
        Animal animal2 = new Mouse("老鼠", 9527);
        animal1.eat();
        animal2.eat();

        Object obj = animal1;
        System.out.println(obj);
//      2.
        Feeder feeder = new Feeder();
        System.out.println("????????????????????");
        feeder.feed(penguin);
        feeder.feed(mouse);
        feeder.feed(animal1);
        feeder.feed(animal2);
//      3.
        Animal a = feeder.catchOne(1);
        Animal aa = feeder.catchOne(2);
        System.out.println(a);
//        判断a是不是企鹅的对象
        if (a instanceof Penguin) {
            Penguin p = (Penguin) a;
            p.catchFish();
        }
    }
}

/*

    英雄类俩方法 : 攻击,移动
    子类继承,法师,ad
    玩家类 控制移动攻击,控制不同英雄,切换英雄

    英雄

 */
