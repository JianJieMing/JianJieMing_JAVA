package com.jianjieming.study.entity;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 23:18
 */
public class UserMoney extends TbUser{
    private long userId;
    private String userName;
    private float total;
    private List<TbOrder> orderList;

    @Override
    public String toString() {
        return "UserMoney{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", total=" + total +
                ", orderList=" + orderList +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<TbOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TbOrder> orderList) {
        this.orderList = orderList;
    }
}
