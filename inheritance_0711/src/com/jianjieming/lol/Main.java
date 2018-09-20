package com.jianjieming.lol;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 切换英雄
         */
        Player player = new Player();
        Hero hero = player.control(2);
        hero.attack();
        hero.move();
        /**
         * 大神上线
         */
        Player player1 = new Manito();
        Manito manito = (Manito) player1;
        player1.setName("张三");
        manito.attack();
        manito.move();
        /**
         * 菜鸟上线
         */
        Player player2 = new Newbie();
        Newbie newbie = (Newbie) player2;
        player2.setName("李四");
        newbie.attack();
        newbie.move();
    }
}
