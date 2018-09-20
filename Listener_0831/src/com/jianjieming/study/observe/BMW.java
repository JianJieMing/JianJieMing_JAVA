package com.jianjieming.study.observe;

/**
 * 宝马
 * @author 铭
 * DATE: 18/8/31 上午9:55
 */
public class BMW implements Observer{

    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("宝马: 发动,打开车门");
    }
}
