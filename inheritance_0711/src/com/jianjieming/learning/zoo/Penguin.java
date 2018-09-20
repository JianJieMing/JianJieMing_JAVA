package com.jianjieming.learning.zoo;

/**
 * 企鹅类
 *
 * @author 铭
 */
public class Penguin extends Animal {

    public Penguin(String name, int id) {
        super(name, id);
    }

    public void catchFish() {
        System.out.println(getName() + "正在抓鱼ing");
    }

    /*
        方法的重写:
            在子类中把可以继承过来的方法,重新声明一遍.

            重写中可以改的地方只能有,访问权限修饰符和方法体.
            访问权限不能比父类小.
     */
    public void eat(){
//        调用父类的方法
        super.eat();
        System.out.println(getName() + "在吃鱼");
    }

}
