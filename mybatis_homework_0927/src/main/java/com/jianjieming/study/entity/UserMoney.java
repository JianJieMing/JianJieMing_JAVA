package com.jianjieming.study.entity;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 23:18
 */
public class UserMoney extends TbUser{

    private float total;

    @Override
    public String toString() {
        return "UserMoney{" +
                "total=" + total +
                "} " + super.toString();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
