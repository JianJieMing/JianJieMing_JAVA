package com.jianjieming.test01;

/**
 * @author 铭
 */
public class AD extends Hero {
    public AD(String name) {
        super(name);
    }

    public void controlAttack(Hero hero) {
        System.out.printf("AD: %s 使用物理攻击\n",getName());

    }

    public void controlMove(Hero hero) {
        System.out.printf("AD: %s 快速移动\n",getName());

    }
}
