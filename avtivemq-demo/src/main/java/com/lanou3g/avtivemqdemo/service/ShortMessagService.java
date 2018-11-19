package com.lanou3g.avtivemqdemo.service;

import com.lanou3g.avtivemqdemo.config.ActiveMQConfig;
import com.lanou3g.avtivemqdemo.entity.MsgEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @author 铭
 * 2018/11/19 10:29
 */
@Service
public class ShortMessagService {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue shortMessageQueue;

    public void sendVerifyCode() {
        MsgEntity msgEntity = new MsgEntity();
        msgEntity.setId(10L);
        msgEntity.setPhone("10086");
        msgEntity.setMessage("话费充值");
        jmsMessagingTemplate.convertAndSend(shortMessageQueue, msgEntity);
    }

    @JmsListener(destination = ActiveMQConfig.QUEUE_SHORT_MESSAGE)
    public void receiveMessage(MsgEntity message) {
        System.out.println("接收到消息: " + message);
    }

}
