package com.jianjieming.homework;

import com.jianjieming.homework.duck.FilghtDuck;
import com.jianjieming.homework.duck.RubberDucks;
import com.jianjieming.homework.duck.WildDuck;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Duck duck = new WildDuck();
        System.out.println(duck.getName());
        duck.PerformDuckCall();
        duck.PerformFlight();
        System.out.println("**********************");
        Duck duck1 = new RubberDucks();
        System.out.println(duck1.getName());
        duck1.PerformDuckCall();
        duck1.PerformFlight();
        System.out.println("**********************");
        Duck duck2 = new FilghtDuck();
        System.out.println(duck2.getName());
        duck2.PerformDuckCall();
        duck2.PerformFlight();
    }
}
