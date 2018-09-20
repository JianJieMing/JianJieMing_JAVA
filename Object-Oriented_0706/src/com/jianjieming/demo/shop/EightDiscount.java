package com.jianjieming.demo.shop;

public class EightDiscount implements Discountable{
    @Override
    public float discount(float totalMoney) {
        return totalMoney * 0.8F;
    }
}
