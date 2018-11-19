package com.lanou3g.avtivemqdemo.service;

import com.lanou3g.avtivemqdemo.config.ActiveMQConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 铭
 * 2018/11/19 14:26
 */
@Component
public class OrderHandler {

    @JmsListener(
            destination = ActiveMQConfig.TOPIC_ORDER_LIST,
            containerFactory = "topicListenerContainer"
    )
    public void orderReceive(String message) {
        System.out.println("处理订单消息: " + message);
    }

}
