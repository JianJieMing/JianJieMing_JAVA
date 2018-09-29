package com.jianjieming.study.entity;


import java.io.Serializable;
import java.util.List;

public class TbOrderItem implements Serializable {

  private long orderItemId;
  private long orderId;
  private long goodsId;
  private long goodsQty;

  private TbOrder order;
  private TbGoods goods;

  @Override
  public String toString() {
    return "TbOrderItem{" +
            "orderItemId=" + orderItemId +
            ", orderId=" + orderId +
            ", goodsId=" + goodsId +
            ", goodsQty=" + goodsQty +
            ", order=" + order +
            ", goods=" + goods +
            '}';
  }

  public TbOrder getOrder() {
    return order;
  }

  public void setOrder(TbOrder order) {
    this.order = order;
  }

  public TbGoods getGoods() {
    return goods;
  }

  public void setGoods(TbGoods goods) {
    this.goods = goods;
  }

  public long getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(long orderItemId) {
    this.orderItemId = orderItemId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getGoodsQty() {
    return goodsQty;
  }

  public void setGoodsQty(long goodsQty) {
    this.goodsQty = goodsQty;
  }

}
