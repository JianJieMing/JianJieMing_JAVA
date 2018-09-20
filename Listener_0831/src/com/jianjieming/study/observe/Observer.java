package com.jianjieming.study.observe;

/**
 * 观察者: 接收并处理消息
 *
 * @author 铭
 * DATE: 18/8/31 上午9:47
 */
public interface Observer {

    // 处理消息
    void handleMessage(Subject subject,String message);

}
