package com.jianjieming.test;

/**
 * 玩家类
 *
 * @author 铭
 */
public class Player {
    private String name;
    private Hero hero;

    public Player(String name) {
        this.name = name;
    }

    /**
     * 控制攻击
     */
    public void controlToAttack() {
        System.out.print(name + "控制");
        hero.attack();
    }

    /**
     * 控制移动
     */
    public void controlToMove() {
        System.out.print(name + "控制");
        hero.move();
    }

    /**
     * 切换英雄
     *
     * @param hero
     */
    public void select(Hero hero) {
        this.hero = hero;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
