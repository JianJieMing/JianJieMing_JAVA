package com.lanou3g.avtivemqdemo.service;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Topic;

/**
 * @author 铭
 * 2018/11/19 14:18
 */
@Service
public class OrderService {

    @Resource
    public JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic orderTopic;

    public String DisposeOrder() {
        jmsMessagingTemplate.convertAndSend(orderTopic, "处理订单" + Math.random());
        return "订单处理完成";
    }

}
