package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Warrior extends Hero {

    public Warrior() {
//        为攻击和移动的两个接口赋值
        attackable = new KnifeAttack();
        moveable = new NormalMove();
    }
}
