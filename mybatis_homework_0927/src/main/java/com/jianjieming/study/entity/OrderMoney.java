package com.jianjieming.study.entity;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 17:52
 */
public class OrderMoney extends TbGoods{

    private long orderId;
    private String orderCode;
    private long userId;
    private float money;
    private TbUser user;
    private List<TbOrderItem> tbOrderItemList;

    @Override
    public String toString() {
        return "OrderMoney{" +
                "orderId=" + orderId +
                ", orderCode='" + orderCode + '\'' +
                ", userId=" + userId +
                ", money=" + money +
                ", user=" + user +
                ", tbOrderItemList=" + tbOrderItemList +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public TbUser getUser() {
        return user;
    }

    public void setUser(TbUser user) {
        this.user = user;
    }

    public List<TbOrderItem> getTbOrderItemList() {
        return tbOrderItemList;
    }

    public void setTbOrderItemList(List<TbOrderItem> tbOrderItemList) {
        this.tbOrderItemList = tbOrderItemList;
    }
}
