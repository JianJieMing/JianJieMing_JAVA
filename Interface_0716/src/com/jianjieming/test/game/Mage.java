package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Mage extends Hero {
    public Mage() {
        attackable = new MagicAttack();
        moveable = new BlinkWalk();
    }
}
