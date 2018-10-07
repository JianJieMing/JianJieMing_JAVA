package com.jianjieming.study.service;

import com.jianjieming.study.entity.TbGoodsCategory;
import com.jianjieming.study.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 铭
 * 2018/9/29 16:44
 */
@Service
public class GoodsCategoryService implements IGoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper categoryMapper;

    /*
        @Transactional这个注解标注的方法会放到一个事务中,
        如果标记的是类,那么这个类中的所有方法都在各自的事务中.
        readOnly属性默认值是false,如果设置为true,那么被标记的方法就不会放到事务里.
     */
    @Transactional
    @Override
    public void addCategory(TbGoodsCategory category) {
        categoryMapper.addOne(category);
//        int x = 1 / 0;
    }

    @Override
    public List<TbGoodsCategory> findAll() {
        return categoryMapper.findAll();
    }
}
