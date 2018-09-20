package com.jianjieming.lol;

/**
 * 菜鸟类(使用英雄攻击一次)
 *
 * @author 铭
 */
public class Newbie extends Player {
    /**
     * 攻击方法
     */
    public void attack() {
        System.out.println("菜鸟" + getName() + "正在一次攻击");
    }

    /**
     * 移动方法
     */
    public void move() {
        System.out.println("菜鸟" + getName() + "正在慢速移动");
    }
}
