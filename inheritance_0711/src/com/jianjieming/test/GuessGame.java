package com.jianjieming.test;

/**
 * @author 铭
 */
public class GuessGame {
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();

    public void startGame() {
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int a = (int) (Math.random() * 10);
        System.out.println("I’m thinking of a number between 0 and 9...");
        while (true) {
            System.out.println("随机数是: " + a);
            p1.guess();
            p2.guess();
            p3.guess();
            guessp1 = p1.number;
            System.out.println("Player one guessed" + guessp1);
            guessp2 = p2.number;
            System.out.println("Player two guessed" + guessp2);
            guessp3 = p3.number;
            System.out.println("Player three guessed" + guessp3);
            if (guessp1 == a) {
                p1isRight = true;
            }
            if (guessp2 == a) {
                p2isRight = true;
            }
            if (guessp3 == a) {
                p3isRight = true;
            }
            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player one got it right?" + p1isRight);
                System.out.println("Player two got it right?" + p2isRight);
                System.out.println("Player three got it right?" + p3isRight);
                System.out.println("Game is over.");
                break; //
            } else {
//
                System.out.println("Players will have to try again.");
            } // if/else
        }
    }
}
