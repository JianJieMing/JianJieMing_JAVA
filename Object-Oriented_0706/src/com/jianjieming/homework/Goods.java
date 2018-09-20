package com.jianjieming.homework;

/**
 * 商品类
 *
 * @author 铭
 */
public class Goods {
    public String goodsname; // 商品名称
    public float goodsprice; // 商品价格

    public void myGoods() {
        System.out.printf("商品名称: %s, 商品价格: %s\n", goodsname, goodsprice);
    }
}
