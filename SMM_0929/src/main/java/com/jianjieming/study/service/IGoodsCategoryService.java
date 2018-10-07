package com.jianjieming.study.service;

import com.jianjieming.study.entity.TbGoodsCategory;

import java.util.List;

public interface IGoodsCategoryService {

    void addCategory(TbGoodsCategory category);

    List<TbGoodsCategory> findAll();

}
