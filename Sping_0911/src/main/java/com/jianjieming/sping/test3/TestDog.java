package com.jianjieming.sping.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/11 下午3:31
 */
public class TestDog {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext3.xml");
        Dog3 dog = (Dog3) context.getBean("dog");
        dog.setAge(3);
        dog.bark();
        System.out.println(dog);

        Dog3 dog3 = (Dog3) context.getBean("dog");
        System.out.println(dog3);
        ((ClassPathXmlApplicationContext) context).close();
    }
}
