package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        warrior.attack();
        warrior.move();
        warrior.setAttackable(new MagicAttack());
        warrior.setMoveable(new HorseMove());

        System.out.println("*************");

        Knight knight = new Knight();
        knight.attack();
        knight.move();

        System.out.println("*************");

        Pastor pastor = new Pastor();
        pastor.attack();
        pastor.move();

        System.out.println("*************");

        Mage mage = new Mage();
        mage.attack();
        mage.move();
    }
}
