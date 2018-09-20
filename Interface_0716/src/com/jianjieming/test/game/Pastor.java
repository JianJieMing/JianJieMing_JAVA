package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Pastor extends Hero {
    public Pastor() {
        attackable = new MagicAttack();
        moveable = new HorseMove();
    }
}
