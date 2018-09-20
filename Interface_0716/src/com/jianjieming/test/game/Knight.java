package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Knight extends Hero {
    public Knight() {
        attackable = new KnifeAttack();
        moveable = new HorseMove();
    }
}
