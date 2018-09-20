package com.jianjieming.Test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/12 上午10:54
 */
public class TestPersonClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(1).xml");
        Person person = (Person) context.getBean("person");
        ClassRoom classRoom = (ClassRoom) context.getBean("class");
        System.out.println(person);
        System.out.println(classRoom);

    }
}
