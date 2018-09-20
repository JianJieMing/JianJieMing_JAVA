package com.jianjieming.test;

/**
 * 法师类
 *
 * @author 铭
 */
public class Mage extends Hero {
    public Mage(String name) {
        super(name);
    }

    public void attack() {
        System.out.printf("法师: %s 释放法术攻击\n", getName());
    }

    public void move() {
        System.out.printf("法师: %s 使用瞬步移动\n", getName());
    }

}
