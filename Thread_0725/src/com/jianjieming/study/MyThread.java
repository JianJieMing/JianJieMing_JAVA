package com.jianjieming.study;

/**
 * @author 铭
 */
public class MyThread extends Thread {

//        name是Thread的一个属性,表示该线程的名字.
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        该方法中的代码就是运行在该子线程中的.
        System.out.println(super.getName());
    }

}
