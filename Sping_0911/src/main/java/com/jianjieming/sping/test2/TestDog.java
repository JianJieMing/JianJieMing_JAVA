package com.jianjieming.sping.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/11 下午3:31
 */
public class TestDog {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
        Dog2 dog = (Dog2) context.getBean("dog");
        dog.bark();
        System.out.println(dog);
    }
}
