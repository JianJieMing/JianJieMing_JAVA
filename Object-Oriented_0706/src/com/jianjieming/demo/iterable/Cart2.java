package com.jianjieming.demo.iterable;

import com.jianjieming.demo.shop.Goods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 铭
 */
public class Cart2 implements Iterable<Goods> {

    private List<Goods> goodsList = new ArrayList<>();

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    @Override
    public Iterator iterator() {
        return (Iterator) new ListIterator();
    }

    /**
     * 内部类
     * 集合
     */
    private class ListIterator implements Iterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < goodsList.size();
        }

        @Override
        public Goods next() {
            return goodsList.get(index++);
        }
    }

}
