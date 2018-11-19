package com.lanou3g.avtivemqdemo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author 铭
 * 2018/11/19 10:36
 */
@Configuration
public class ActiveMQConfig {

    public static final String QUEUE_SHORT_MESSAGE = "com.lanou3g.demo.SHORT_MESSAGE_QUEUE";
    public static final String TOPIC_ORDER_LIST = "com.lanou3g.demo.ORDER_LIST_TOPIC";

    // 创建一个目的地的bean
    @Bean
    public Queue shortMessageQueue() {
        return new ActiveMQQueue(QUEUE_SHORT_MESSAGE);
    }

    @Bean
    public Topic orderTopic() {
        return new ActiveMQTopic(TOPIC_ORDER_LIST);
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        return topicListenerContainer;
    }

    // 消息转换器
    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter =
                new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("type");
        return converter;
    }

}
