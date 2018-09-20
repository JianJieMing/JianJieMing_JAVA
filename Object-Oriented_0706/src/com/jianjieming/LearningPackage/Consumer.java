package com.jianjieming.LearningPackage;

/**
 * 顾客类
 *
 * @author 铭
 */
public class Consumer {
    /*
        属性(静态特征):
            在类中声明的变量,就是该类的属性.
            声明的属性用来干嘛的?
            实际上是规定了一种规范:
                规范了该类的所有对象,都有这个几个属性.
            属性的别名: 实例变量 成员变量.
    */

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Consumer(String name) {
        this.name = name;
    }

    //    创建一个商品的数组
    private Goods[] shopping = new Goods[3];
    private int index;

    /*

        访问权限修饰符:
            可以修饰属性和方法,用来规定某个属性或方法的可访问范围.
        1.private 私有的 只能在当前类访问.
        2.default(啥也不写),就是默认的,包访问权限,只能在同一个包下访问.
        3.protected(用的少),子类和包访问权限.
        4.public 公开的 在任何位置都可以访问.

        开发原则: 在以后的开发过程中,所有的属性或方法的访问权限越小越好.

     */


//    Goods[] goodsName = new Goods[3];

    /*
        方法(动态特征):
            方法在某些编程语言中,也称之为函数.
        方法的格式:
            访问权限修饰符 返回值类型 方法名 (参数列表) {
                         方法体;
            }
        返回值: 代表该方法执行后返回的结果.如果没有返回值,该位置填 void

        方法只有调用才会执行,同一个方法可以调用多次.

        调用方法:
            对象名.方法名(参数);
     */

    public void buy() {
//        在成员方法中调用了成员变量的时候,
//        哪个对象调用了该方法,那么该成员变量就是哪个对象的属性.
        System.out.println("顾客名称: " + name);
        float totalPrice = 0F;
//        遍历购物车,取出数组中每个元素(Goods的对象).
//        for (int i = 0; i < shopping.length; i++) {
//            将Goods对象的price属性累加起来.
//            为了防止不必要出现的空指针异常,
//            在调用某个对象的属性之前,做非null判断.
//            if (shopping[i] != null) {
//                totalPrice = totalPrice + shopping[i].price;
//            }
//        }
//        for (int i = 0; i < goodsName.length; i++) {
//            if (goodsName[i] != null) {
//                System.out.println("商品有: " + goodsName[i].name);
//            }
//        }
        for (int j = 0; j < shopping.length; j++) {
//            将Goods对象的price属性累加起来.
//            为了防止不必要出现的空指针异常,
//            在调用某个对象的属性之前,做非null判断.
            if (shopping[j] != null) {
                totalPrice = totalPrice + shopping[j].getPrice();
                shopping[j].print();
            }
        }

        System.out.println("商品总价为: " + totalPrice);
    }

    /*
        方法的参数:
            1.参数可以有多个,多个参数之间,使用逗号隔开.
            2.方法的参数,实际上也是制定了一个规范:
                参数声明的是什么类型,那么在方法的调用时,就要填入什么类型.
            3.方法中的参数,也叫做形参(形式参数).
            4.多个参数,声明的是什么顺序,那么调用时就要按照该顺序填入参数.
     */

//    public void eat(String food, int count) {
//        System.out.println(name + "吃了" + food);
//    }


    /**
     * 用来向购物车中添加商品
     *
     * @param goods 需要添加的商品
     */
    void add(Goods goods) {
        if (index < shopping.length) {
            shopping[index] = goods;
            index++;
        } else {
            System.out.println("购物车已满," + goods.getName() + "放入失败.");
        }
    }



}
