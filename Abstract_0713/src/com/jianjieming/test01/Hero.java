package com.jianjieming.test01;

/**
 * @author 铭
 */
public class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + "攻击");
    }

    public void move() {
        System.out.println(name + "移动");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
