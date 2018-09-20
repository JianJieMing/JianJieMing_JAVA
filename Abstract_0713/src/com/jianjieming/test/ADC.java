package com.jianjieming.test;

/**
 * 射手类
 *
 * @author 铭
 */
public class ADC extends Hero {

    public ADC(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("adc使用远程物理攻击");
    }

    @Override
    public void move() {
        System.out.println("adc正常移动");
    }
}
