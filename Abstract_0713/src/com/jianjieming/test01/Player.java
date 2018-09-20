package com.jianjieming.test01;

/**
 * @author 铭
 */
public class Player {
    private String name;
    private Hero hero;

    public Player(String name) {
        this.name = name;
    }

    public void controlAttack() {
        System.out.print(name + "控制");
        hero.attack();
    }

    public void controlMove() {
        System.out.print(name + "控制");
        hero.move();
    }

    public void select(Hero hero){
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
