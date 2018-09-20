package com.jianjieming.test;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Mage("卡特");
        Hero hero2 = new Assassin("劫");
        Hero hero3 = new Warrior("锐雯");
        Hero hero4 = new ADC("金克丝");

//        匿名内部类对象
//        代表创建了一个没有名字的类,继承了Hero类,并且重写了两个方法.
        Hero hero5 = new Hero("") {
            @Override
            public void attack() {
                System.out.println("匿名的方法");
            }

            @Override
            public void move() {

            }
        };
        hero5.attack();

        Player player1 = new Manito("彩旗");
        Player player2 = new Manito("黑白");
        Player player3 = new Manito("Uzi");
        /**
         * 具体的业务逻辑
         */
//        玩家一
        player1.select(hero1);
        player1.controlToMove();
        player1.controlToAttack();
        player1.select(hero2);
        player1.controlToMove();
        player1.controlToAttack();
//        玩家二
        player2.select(hero3);
        player2.controlToMove();
        player2.controlToAttack();
        player3.select(hero4);
        player3.controlToMove();
        player3.controlToAttack();

    }
}
