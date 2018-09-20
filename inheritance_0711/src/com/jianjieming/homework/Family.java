package com.jianjieming.homework;

/**
 * 家庭类
 *
 * @author 铭
 */
public class Family {
    private Man man;
    private Woman woman;
    private Child child;


    public Family(Man man, Woman woman, Child child) {
        this.man = man;
        this.woman = woman;
        this.child = child;

        man.setMother3(woman);
        man.setChild3(child);

        child.setFather(man);
        child.setMother(woman);

        woman.setFather(man);
        woman.setChild(child);
    }

    public void tourism() {
        System.out.println(man.getName() + "和" + woman.getName() + "和" + child.getName() + "一起去旅游");
    }

}
