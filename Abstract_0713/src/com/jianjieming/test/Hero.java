package com.jianjieming.test;

/**
 * 英雄类
 *
 * @author 铭
 */
public abstract class Hero {

    /*
        1. 如果一个类中有抽象方法,那么这个类一定是抽象类.
        2. 抽象类的作用就是规定了,父类知道有某个方法,但是不知道具体怎么执行.
        3. 如果一个普通类继承了抽象类,那么必须重写抽象类的所有抽象方法.
     */

    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void move();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
