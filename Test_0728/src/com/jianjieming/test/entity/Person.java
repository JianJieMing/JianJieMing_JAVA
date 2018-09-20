package com.jianjieming.test.entity;

/**
 * @author 铭
 */
public class Person {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("无参方法");
    }

    public void eat(String name) {
        System.out.println("一个参数");
    }

    public void eat(String name, int age) {
        System.out.println("两个参数");
    }

    private void eat(int age) {
        System.out.println("一个参数的私有方法");
    }
}
