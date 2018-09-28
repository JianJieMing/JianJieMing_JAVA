package com.jianjieming.study.entity;


import java.util.List;

public class TbGoodsCategory {

  private long categoryId;
  private String categoryName;

  private List<TbGoods> goodsList;

  @Override
  public String toString() {
    return "TbGoodsCategory{" +
            "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", goodsList=" + goodsList +
            '}';
  }

  public List<TbGoods> getGoodsList() {
    return goodsList;
  }

  public void setGoodsList(List<TbGoods> goodsList) {
    this.goodsList = goodsList;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

}
