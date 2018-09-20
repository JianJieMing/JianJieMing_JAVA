package com.jianjieming.learning.zoo;

/**
 * 饲养员类
 *
 * @author 铭
 */
public class Feeder {

    public void feed(Animal animal) {
        animal.eat();
    }

    public Animal catchOne(int type) {
        switch (type) {
            case 1:
//                匿名对象
                return new Penguin("1企鹅", 1235);
            case 2:
                return new Mouse("2老鼠", 1006);
        }
        return null;
    }
//    public void feed(Mouse mouse){
//        mouse.eat();
//    }
}
