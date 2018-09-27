package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoodsCategory;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 9:57
 */
public interface CategoryMapper {

    // 只查询tb_goods_category单表
    List<TbGoodsCategory> findAllSimple();

    // 会把某个类别所对应的商品也查出来
    List<TbGoodsCategory> findAll();

}
