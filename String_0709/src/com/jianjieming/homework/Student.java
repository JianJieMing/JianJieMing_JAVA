package com.jianjieming.homework;

public class Student {
    private String name;
    private int age;
    private String happy;

    public String setName(String name){
        this.name = name;
        return name;
    }

    public int setAge(int age){
            this.age = age;
            return age;
    }

    public String setHappy(String happy){
        this.happy = happy;
        return happy;
    }

    public String getName(String name){
        return name;
    }

    public int getAge(int age){
        return age;
    }

    public String getHappy(String happy){
        return happy;
    }

    public void introduce(){
        System.out.println("我叫" + getName("李四") + ",今年" + getAge(17) + "岁了,爱好" + getHappy("打游戏"));
    }

}
