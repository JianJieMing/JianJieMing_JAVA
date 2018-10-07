package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoodsCategory;
import com.jianjieming.study.service.IGoodsCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class GoodsCategoryMapperTest {

//    @Autowired
//    private GoodsCategoryMapper categoryMapper;

    @Autowired
    private IGoodsCategoryService goodsCategoryService;

//    @Test
//    public void findAll(){
//        List<TbGoodsCategory> all = categoryMapper.findAll();
//        all.forEach(System.out::println);
//    }

    @Test
    public void addOne() {
        TbGoodsCategory goodsCategory = new TbGoodsCategory();
        goodsCategory.setCategoryName("大帅哥");
        goodsCategoryService.addCategory(goodsCategory);
    }

}