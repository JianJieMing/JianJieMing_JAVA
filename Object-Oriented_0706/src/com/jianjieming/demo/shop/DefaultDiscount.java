package com.jianjieming.demo.shop;

/**
 * 不打折
 */
public class DefaultDiscount implements Discountable {
    @Override
    public float discount(float totalMoney) {
        return totalMoney;
    }
}
