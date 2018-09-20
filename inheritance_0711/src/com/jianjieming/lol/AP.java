package com.jianjieming.lol;

/**
 * @author 铭
 */
public class AP extends Hero{
    public AP(String name) {
        super(name);
    }

    /**
     * 攻击方法
     */
    public void attack() {
        System.out.println(getName() + "使用魔法攻击");
    }

    /**
     * 移动方法
     */
    public void move() {
        System.out.println(getName() + "慢速移动中");
    }

}
