package com.jianjieming.test;

/**
 * @author 铭
 */
public class Test01 {
    private String name;
    private int age;
    private String happy;

    public Test01(String name, int age, String happy) {
        this.name = name;
        this.age = age;
        this.happy = happy;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int setAge(int age) {
        this.age = age;
        return age;
    }

    public String setHappy(String happy) {
        this.happy = happy;
        return happy;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHappy() {
        return happy;
    }
}

