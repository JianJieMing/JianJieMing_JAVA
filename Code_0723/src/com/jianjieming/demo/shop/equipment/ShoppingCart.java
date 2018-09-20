package com.jianjieming.demo.shop.equipment;

public class ShoppingCart extends GoodsCart {
    @Override
    public int maxSize() {
        return 20;
    }

    @Override
    public String getCartName() {
        return "购物车";
    }
}
