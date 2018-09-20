package com.jianjieming.test;

/**
 * 刺客类
 * @author 铭
 */
public class Assassin extends Hero{

    public Assassin(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("刺客: 使用匕首刺杀");
    }

    @Override
    public void move() {
        System.out.println(getName() + " :隐身潜行移动");
    }
}
