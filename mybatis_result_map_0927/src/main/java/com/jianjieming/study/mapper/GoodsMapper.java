package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoods;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 9:57
 */
public interface GoodsMapper {

    /**
     * 查询所有商品,并且把每个商品的类别信息携带出来
     * @return
     */
    List<TbGoods> findAllWithCategory();

}
