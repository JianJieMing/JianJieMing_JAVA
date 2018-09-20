package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Person {
    private String name;
    private int age;
    private float height;

    public void print(){
        System.out.printf("我叫 %s,我今年 %s 岁了!",name,age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


}
