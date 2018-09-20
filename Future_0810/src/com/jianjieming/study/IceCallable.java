package com.jianjieming.study;

import java.util.concurrent.Callable;

/**
 * @author 铭
 */
public class IceCallable implements Callable<Integer> {

    private int money;

    public IceCallable(int money) {
        this.money = money;
    }

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("小弟开始去买雪糕");
            Thread.sleep(1000);
            System.out.println("小弟买完雪糕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money - 2;
    }
}
