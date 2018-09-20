package com.jianjieming.lol;

/**
 * 大神类(使用英雄可以多次攻击)
 *
 * @author 铭
 */
public class Manito extends Player {

    /**
     * 攻击方法
     */
    public void attack() {
        System.out.println("大神" + getName() + "正在多次攻击");
    }

    /**
     * 移动方法
     */
    public void move() {
        System.out.println("大神" + getName() + "正在移动");
    }
}
