package com.jianjieming.demo.iterable;

import com.jianjieming.demo.shop.Goods;

import java.util.Iterator;

/**
 * 迭代器类
 *
 * @author 铭
 */
public class IteratorMain {
    public static void main(String[] args) {
        /*
            迭代器模式
            以一个统一的方式去遍历不同类型的容器
         */


        Cart1 cart1 = new Cart1();
        Cart2 cart2 = new Cart2();

//        使用迭代器统一遍历
        forEach(cart1);
        forEach(cart2);
    }


    private static void forEach(Iterable<Goods> iterable) {
        Iterator<Goods> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Goods g = iterator.next();
        }
    }


    //    遍历第一个数组
    private static void forEachCart1(Cart1 cart1) {
        for (int i = 0; i < cart1.getGoodsArray().length; i++) {
            Goods g = cart1.getGoodsArray()[i];
        }
    }

    //    遍历第二个集合
    private static void forEachCart2(Cart2 cart2) {
        for (int i = 0; i < cart2.getGoodsList().size(); i++) {
            Goods g = cart2.getGoodsList().get(i);
        }
    }

}
