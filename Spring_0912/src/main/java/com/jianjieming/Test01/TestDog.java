package com.jianjieming.Test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/12 上午9:53
 */
public class TestDog {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(1).xml");
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
    }
}
