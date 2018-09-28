package com.jianjieming.study.entity;


import java.util.List;

public class TbUser {

  private long userId;
  private String userName;

  private List<TbOrder> orderList;

  @Override
  public String toString() {
    return "TbUser{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", orderList=" + orderList +
            '}';
  }

  public List<TbOrder> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<TbOrder> orderList) {
    this.orderList = orderList;
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

}
