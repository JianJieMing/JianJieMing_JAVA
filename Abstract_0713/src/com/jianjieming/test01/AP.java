package com.jianjieming.test01;

/**
 * @author 铭
 */
public class AP extends Hero{
    public AP(String name) {
        super(name);
    }

    public void controlAttack(Hero hero) {
        System.out.println("使用魔法攻击");

    }

    public void controlMove(Hero hero) {
        System.out.println("慢速移动");

    }

}
