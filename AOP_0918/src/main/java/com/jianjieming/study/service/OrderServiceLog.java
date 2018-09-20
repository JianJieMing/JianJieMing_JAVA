package com.jianjieming.study.service;

/**
 * @author 铭
 * DATE: 18/9/18 上午10:20
 */
public class OrderServiceLog extends OrderService {
    @Override
    public void findAll() {
        System.out.println("OrderService.findAll 开始执行");
        super.findAll();
        System.out.println("OrderService.findAll 执行结束");
    }
}
