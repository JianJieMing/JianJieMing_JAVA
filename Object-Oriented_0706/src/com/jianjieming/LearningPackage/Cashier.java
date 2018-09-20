package com.jianjieming.LearningPackage;

/**
 * 收银员
 *
 * @author 铭
 */
public class Cashier {
    private String name;
    private int age;
    private int id;

    public Cashier(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}
