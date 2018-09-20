package com.jianjieming.study;

/**
 * 函数式接口:
 * 1.接口中只有一个抽象方法
 * 2.或者有一些Object类的方法
 * 3.或者有一些default方法
 * 结论: 接口中只能存在一个必须实现的抽象方法.
 *
 * @author 铭
 */
//  @FunctionalInterface是用来检测某个接口是不是函数式接口
@FunctionalInterface
public interface AddCalculator {

    int add(int x, int y);

    boolean equals(Object obj);

    default void fun() {
        System.out.println("我是计算加法的接口");
    }

    int hashCode();

}
