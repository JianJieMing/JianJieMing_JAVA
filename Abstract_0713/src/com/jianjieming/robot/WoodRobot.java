package com.jianjieming.robot;

/**
 * @author 铭
 */
public class WoodRobot extends Robot {
    @Override
    protected void createHead() {
        System.out.println("我来组成头部");
    }

    @Override
    protected void createBody() {
        System.out.println("我来组成身体");
    }

    @Override
    protected void createArm() {
        System.out.println("我来组成手臂");
    }

    @Override
    protected void createLeg() {
        System.out.println("我来组成大腿");
    }
}
