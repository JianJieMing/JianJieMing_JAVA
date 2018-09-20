package com.jianjieming.homework;

/**
 * 女人类
 *
 * @author 铭
 */
public class Woman extends Person {
    private Man father;
    private Child child;

    public void cookDinner() {
        super.getChild();
        System.out.println(getName() + "在给" + father.getName() + "和" + child.getName() + "做饭");
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
