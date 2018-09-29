package com.jianjieming.study.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class TbUser implements Serializable {

  private Long userId;
  private String userName;
  private String gender;
  private Float height;
  private Float weight;
  private Date birthday;
  private Integer deleteFlag;

  private List<TbOrder> orderList;

  @Override
  public String toString() {
    return "TbUser{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", gender='" + gender + '\'' +
            ", height=" + height +
            ", weight=" + weight +
            ", birthday=" + birthday +
            ", deleteFlag=" + deleteFlag +
            ", orderList=" + orderList +
            '}';
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Integer deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public List<TbOrder> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<TbOrder> orderList) {
    this.orderList = orderList;
  }
}
