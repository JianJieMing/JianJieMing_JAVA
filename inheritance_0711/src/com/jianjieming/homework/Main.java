package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        Child child = new Child();
        Family family = new Family(man, woman, child);


        man.setName("张三");
        child.setName("小明");
        woman.setName("姗姗");


        man.work();
        woman.cookDinner();
        child.attendSchool();
        family.tourism();
    }
}
