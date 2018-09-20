package com.jianjieming.test01;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {

        Hero hero1 = new AP("卡特");
        Hero hero2 = new AD("剑姬");
        Hero hero3 = new AD("瑞文");

        Player player1 = new Manito("张三");
        Player player2 = new Player("李四");

        player1.select(hero1);
        player1.controlAttack();
        player1.controlMove();
        player2.select(hero2);
        player2.controlMove();
        player2.controlAttack();

    }
}
