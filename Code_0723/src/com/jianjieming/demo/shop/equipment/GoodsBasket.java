package com.jianjieming.demo.shop.equipment;

public class GoodsBasket extends GoodsCart {
    @Override
    public int maxSize() {
        return 10;
    }

    @Override
    public String getCartName() {
        return "篮子";
    }
}
