package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {

    TbGoodsCategory findById(Integer id);

    List<TbGoodsCategory> findAllWithGoods();

}
