package com.jianjieming.test;

public class Main {
    public static void main(String[] args) {
        Father father = new Father();
        father.name = "张三";
        father.age = 33;

        father.drive();
        father.work();
        father.say();
    }
}
