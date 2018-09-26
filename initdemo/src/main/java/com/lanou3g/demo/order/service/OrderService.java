package com.lanou3g.demo.order.service;

import com.lanou3g.demo.bean.BookBean;
import org.springframework.stereotype.Service;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Service
public class OrderService implements IOrderService {
    @Override
    public BookBean test() {
        return new BookBean();
    }
}
