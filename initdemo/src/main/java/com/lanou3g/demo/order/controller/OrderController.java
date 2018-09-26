package com.lanou3g.demo.order.controller;

import com.lanou3g.demo.bean.BookBean;
import com.lanou3g.demo.order.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @RequestMapping("/test")
    @ResponseBody
    public BookBean test(){
        return orderService.test();
    }


}
