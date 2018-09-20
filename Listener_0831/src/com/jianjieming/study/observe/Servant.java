package com.jianjieming.study.observe;

/**
 * 小弟
 * @author 铭
 * DATE: 18/8/31 上午9:57
 */
public class Servant implements Observer{

    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("随从: 大喊" + message);
    }
}
