package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.OrderMoney;
import com.jianjieming.study.entity.TbGoods;
import com.jianjieming.study.entity.TbOrder;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 9:57
 */
public interface OrderMapper {

    // 1. 查询所有订单, 并携带订单项和商品
    List<TbOrder> queryOrderAndGoods();

    // 2. 根据id查询某个订单, 并携带订单项和商品
    List<TbOrder> queryOrderAndOrderitemAndGoods(TbOrder tbOrder);

    // 3. 查询所有订单和订单的总价
    List<OrderMoney> queryOrderMoney();

}
