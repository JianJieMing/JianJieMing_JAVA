package com.lanou3g.avtivemqdemo.controller;

import com.lanou3g.avtivemqdemo.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 铭
 * 2018/11/19 14:22
 */
@RestController
@RequestMapping("/order")
public class OrderListController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/dispose")
    public String dispose() {
        return orderService.DisposeOrder();
    }

}
