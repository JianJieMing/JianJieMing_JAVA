package com.jianjieming.study.entity;


import sun.dc.pr.PRError;

import java.util.List;

public class TbGoods {

  private long goodsId;
  private long categoryId;
  private String goodsName;
  private double goodsPrice;

  private TbGoodsCategory tbGoodsCategory;
  private List<TbOrderItem> tbOrderItemList;

  @Override
  public String toString() {
    return "TbGoods{" +
            "goodsId=" + goodsId +
            ", categoryId=" + categoryId +
            ", goodsName='" + goodsName + '\'' +
            ", goodsPrice=" + goodsPrice +
            ", tbGoodsCategory=" + tbGoodsCategory +
            ", tbOrderItemList=" + tbOrderItemList +
            '}';
  }

  public List<TbOrderItem> getTbOrderItemList() {
    return tbOrderItemList;
  }

  public void setTbOrderItemList(List<TbOrderItem> tbOrderItemList) {
    this.tbOrderItemList = tbOrderItemList;
  }

  public TbGoodsCategory getTbGoodsCategory() {
    return tbGoodsCategory;
  }

  public void setTbGoodsCategory(TbGoodsCategory tbGoodsCategory) {
    this.tbGoodsCategory = tbGoodsCategory;
  }

  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

}
