package com.jianjieming.test;

/**
 * 战士类
 *
 * @author 铭
 */
public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
    }

    public void attack() {
        System.out.printf("战士: %s 使用光速QA攻击\n", getName());
    }

    public void move() {
        System.out.printf("战士: %s 使用疾跑移动\n", getName());
    }

}
