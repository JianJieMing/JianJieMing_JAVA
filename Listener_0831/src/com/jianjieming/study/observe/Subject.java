package com.jianjieming.study.observe;

/**
 * 主题: 发布消息
 *
 * @author 铭
 * DATE: 18/8/31 上午9:46
 */
public interface Subject {

    // 发送消息
    void notifyObserver(String message);

    // 添加观察者
    void addObserver(Observer o);

    // 移除观察者
    void removeObserver(Observer o);


}
