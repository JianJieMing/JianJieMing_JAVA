package com.jianjieming.test;

/**
 * @author 铭
 */
public interface Computable {
    /*
        接口标识的是一种能力.
        关键字: Interface

        可以把接口看做是一个特殊的类,但不是类.
        1. 接口中的方法都是public的抽象方法,所有public和abstract可以省略不写.
        2. 接口中的属性都是全局常量. public static final 可以省略,必须给初始值.

        抽象类是为了被继承的,接口是为了被实现的.
        继承: extends
        实现: implements

        一个类只能直接继承一个类,但是可以实现多个接口.
        多个接口之间,使用逗号`,`隔开.

        Java中类是单继承的,但是接口是多继承的.

        之前说过的多态,接口同样满足.

     */

    int TYPE_0 = 0;

    int compute(int x, int y);

}
