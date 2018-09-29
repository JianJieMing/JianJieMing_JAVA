package com.jianjieming.study.entity;


import java.io.Serializable;
import java.util.List;

public class TbOrder implements Serializable {

  private long orderId;
  private String orderCode;
  private long userId;

  private TbUser user;
  private List<TbOrderItem> tbOrderItemList;

  @Override
  public String toString() {
    return "TbOrder{" +
            "orderId=" + orderId +
            ", orderCode='" + orderCode + '\'' +
            ", userId=" + userId +
            ", user=" + user +
            ", tbOrderItemList=" + tbOrderItemList +
            '}';
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

}
