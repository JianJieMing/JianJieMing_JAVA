package com.jianjieming.lol;

/**
 * @author 铭
 */
public class AD extends Hero {
    public AD(String name) {
        super(name);
    }

    /**
     * 攻击方法
     */
    public void attack() {

        System.out.println(getName() + "使用武器攻击");
    }

    /**
     * 移动方法
     */
    public void move() {

        System.out.println(getName() + "快速移动中");
    }
}
