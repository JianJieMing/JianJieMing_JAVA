package com.jianjieming.sping.test3;

/**
 * @author 铭
 * DATE: 18/9/11 上午11:42
 */
public class Dog3 {
    private String name;
    private Integer age;

    public Dog3() {
        System.out.println("无参的构造方法");
    }

    public Dog3(String name, Integer age) {
        System.out.println("有参的构造方法");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("get Name");
        return name;
    }

    public void setName(String name) {
        System.out.println("set Name");
        this.name = name;
    }

    public int getAge() {
        System.out.println("get Age");
        return age;
    }

    public void setAge(int age) {
        System.out.println("set Age");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void bark() {
        System.out.println("旺旺");
    }

    public void initDog() {
        System.out.println("init dog");
    }

    public void destroyDog() {
        System.out.println("destray dog");
    }
}
