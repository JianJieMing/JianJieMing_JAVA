package com.jianjieming.test.game;

/**
 * @author 铭
 */
public class Hero {

    protected Attackable attackable;
    protected Moveable moveable;

    /*
        要求:
            战士: 用刀砍 走路
            法师: 用魔法攻击 闪现走路
            骑士: 用刀砍 骑马走路
            牧师: 用魔法攻击 骑马走路
     */
    public void attack() {
        attackable.attack();
    }

    public void move() {
        moveable.move();
    }


    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }
}
