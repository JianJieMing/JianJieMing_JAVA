package com.jianjieming.study.entity;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 17:52
 */
public class OrderMoney extends TbOrder{

    private float money;

    @Override
    public String toString() {
        return "OrderMoney{" +
                "money=" + money +
                "} " + super.toString();
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
