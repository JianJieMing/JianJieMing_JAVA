package com.jianjieming.homework.goodscart;

import com.jianjieming.homework.function.Goods;

import java.util.List;

/**
 * 货物类
 * 购物车和货架的父类
 * @author 铭
 */
public class GoodsContainer {
    private List<GoodsCell> goodsCells;

    public class GoodsCell{
        private Goods goods;
        private int quantity;
    }
}
