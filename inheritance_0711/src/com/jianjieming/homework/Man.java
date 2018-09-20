package com.jianjieming.homework;

/**
 * 男人类
 *
 * @author 铭
 */
public class Man extends Person {
    private Woman mother3;
    private Child child3;

    public void work() {
        System.out.println(getName() + "在给" + mother3.getName() + "和" + child3.getName() + "赚钱");
    }

    public void setMother3(Woman mother3) {
        this.mother3 = mother3;
    }

    public void setChild3(Child child3) {
        this.child3 = child3;
    }
}
