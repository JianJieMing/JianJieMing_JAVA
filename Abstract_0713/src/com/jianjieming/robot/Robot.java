package com.jianjieming.robot;

/**
 * 机器人组装
 * 模板方法模式
 *
 * @author 铭
 */
public abstract class Robot {

    public final void create() {
        System.out.println("缺个脑袋");
        createHead();
        System.out.println("缺个身体");
        createBody();
        System.out.println("缺个手臂");
        createArm();
        System.out.println("缺个大腿");
        createLeg();
    }

    protected abstract void createHead();

    protected abstract void createBody();

    protected abstract void createArm();

    protected abstract void createLeg();
}
