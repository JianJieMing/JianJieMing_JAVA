package com.jianjieming;

import java.util.Random;

public class Test06 {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(6)+1;
        if (a > 3){
            System.out.println("大" + a);
        } else {
            System.out.println("小" + a);
        }
    }
}
