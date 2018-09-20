package com.jianjieming.demo.iterable;

import com.jianjieming.demo.shop.Goods;

import java.util.Iterator;

/**
 * 购物车1
 *
 * @author 铭
 */
public class Cart1 implements Iterable<Goods> {


    private Goods[] goodsArray = new Goods[10];


    public Goods[] getGoodsArray() {
        return goodsArray;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    /**
     * 内部类
     * 数组
     */
    private class ArrayIterator implements Iterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < goodsArray.length;
        }

        @Override
        public Goods next() {
            return goodsArray[index++];
        }
    }

}
