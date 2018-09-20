package com.jianjieming.study;

/**
 * @author 铭
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("无参的方法");
    }

    public void eat(String food) {
        System.out.println("一个参数的方法" + food);
    }

    public void eat(String food, int times) {
        System.out.println("两个参数的方法" + food + "    " + times);
    }
}
