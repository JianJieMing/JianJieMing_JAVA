package com.jianjieming.learning.zoo;

/**
 * 老鼠类
 *
 * @author 铭
 */
public class Mouse extends Animal {

    public Mouse(String name, int id) {
        super(name, id);
    }

    public void StealingOil() {
//        使用从父类继承来的属性.
        System.out.println(getName() + "正在遛猫");
    }

    public void eat() {
        System.out.println(getName() + "正在吃猫食");
    }


}
