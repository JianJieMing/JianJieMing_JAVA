package com.jianjieming.demo.shop.staff;


import com.jianjieming.demo.shop.base.Staff;
import com.jianjieming.demo.shop.equipment.GoodsCart;

public class Cashier extends Staff {



    public float check(GoodsCart cart){
        float money = cart.compute();
        return money;
    }
}
