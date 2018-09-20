package com.jianjieming.test;

/**
 * 大神类
 *
 * @author 铭
 */
public class Manito extends Player {
    public Manito(String name) {
        super(name);
    }

    public void controlToAttack() {
        System.out.printf("大神玩家: %s 控制\n", getName());
        getHero().attack();
        getHero().attack();
        getHero().attack();
    }

}
