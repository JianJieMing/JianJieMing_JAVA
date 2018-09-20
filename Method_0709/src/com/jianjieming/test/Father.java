package com.jianjieming.test;

/**
 * 父亲类
 *
 * @author 铭
 */
public class Father {
    public String name;
    public int age;

    /**
     * 工作
     */
    public void work() {
        System.out.println("工作");
    }

    /**
     * 开车
     */
    public void drive() {
        System.out.println("开车");
    }

    public void say() {
        System.out.println(name + "今年" + age + "岁了");
    }
}
