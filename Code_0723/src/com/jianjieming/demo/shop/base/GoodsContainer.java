package com.jianjieming.demo.shop.base;

import com.jianjieming.demo.shop.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * 货架和购物车的父类
 */
public abstract class GoodsContainer {

    /**
     * 用来存储货架上的所有商品
     */
    protected List<GoodsCell> cells;

    public GoodsContainer() {
        cells = new ArrayList<>();
    }

    /**
     * 添加货物的方法, 由于子类货架和购物车的添加商品方法实现不同,<p></p>
     * 所以定义为抽象类
     * @param goods 需要向商品容器中添加的商品
     * @param quantity 商品的数量
     */
    public abstract void addGoods(Goods goods, int quantity);

    /**
     * 货物容器的内部类, 用来保存商品信息和商品数量
     */
    public class GoodsCell{
        /** 商品 */
        private Goods goods;
        /** 商品数量 */
        private int quantity;

        public GoodsCell() {
        }

        public GoodsCell(Goods goods, int quantity) {
            this.goods = goods;
            this.quantity = quantity;
        }

        public Goods getGoods() {
            return goods;
        }

        public void setGoods(Goods goods) {
            this.goods = goods;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


}
