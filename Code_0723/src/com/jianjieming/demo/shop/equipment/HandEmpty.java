package com.jianjieming.demo.shop.equipment;

public class HandEmpty extends GoodsCart {
    @Override
    public int maxSize() {
        return 5;
    }

    @Override
    public String getCartName() {
        return "空手";
    }
}
