package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoods;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 9:57
 */
public interface GoodsMapper {

    /**
     * 查询所有商品,并且携带出商品的种类
     * @return
     */
    List<TbGoods> findAll();

}
