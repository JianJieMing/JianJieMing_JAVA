package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoodsCategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsCategoryMapper {

    @Select("select * from tb_goods_category")
    List<TbGoodsCategory> findAll();

    int addOne(TbGoodsCategory category);
}
