package com.jianjieming.sping.test2;

/**
 * @author 铭
 * DATE: 18/9/11 上午11:42
 */
public class Dog2 {
    private String name;
    private Integer age;

    public Dog2() {
        System.out.println("无参的构造方法");
    }

    public Dog2(String name, Integer age) {
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
}
