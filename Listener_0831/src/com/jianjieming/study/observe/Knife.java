package com.jianjieming.study.observe;

/**
 * 小刀
 *
 * @author 铭
 * DATE: 18/8/31 上午9:57
 */
public class Knife implements Observer {

    @Override
    public void handleMessage(Subject subject,String message) {
        System.out.println("小刀: 掉地上了");
        subject.removeObserver(this);
    }
}
