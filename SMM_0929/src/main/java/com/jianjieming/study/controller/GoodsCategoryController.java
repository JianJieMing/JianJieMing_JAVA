package com.jianjieming.study.controller;

import com.jianjieming.study.entity.TbGoodsCategory;
import com.jianjieming.study.service.IGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 铭
 * 2018/9/29 17:35
 */
@Controller
@RequestMapping("/category")
public class GoodsCategoryController {

    @Autowired
    private IGoodsCategoryService goodsCategoryService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<TbGoodsCategory> findAll() {
        return goodsCategoryService.findAll();
    }

}
