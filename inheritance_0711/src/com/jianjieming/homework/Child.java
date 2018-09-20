package com.jianjieming.homework;

/**
 * 孩子类
 *
 * @author 铭
 */
public class Child extends Person {
    private Man father;
    private Woman mother;

    public void attendSchool() {
        System.out.println(getName() + "上学" + ",他的爸爸妈妈是:" + father.getName() + "和" + mother.getName());
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }
}
