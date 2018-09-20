package com.jianjieming.lol;

/**
 * 英雄类
 * 有移动和攻击的方法
 * @author 铭
 */
public class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    /**
     * 攻击方法
     */
    public void attack(){
        System.out.println(name + "正在攻击");
    }

    /**
     * 移动方法
     */
    public void move(){
        System.out.println(name + "正在移动");
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
