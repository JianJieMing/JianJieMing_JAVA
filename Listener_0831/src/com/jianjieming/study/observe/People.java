package com.jianjieming.study.observe;

/**
 * @author 铭
 * DATE: 18/8/31 上午10:12
 */
public class People implements Observer {
    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("路人跑了");
        subject.removeObserver(this);
    }
}
