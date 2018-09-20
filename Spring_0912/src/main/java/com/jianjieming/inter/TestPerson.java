package com.jianjieming.inter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:21
 */
public class TestPerson {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(2).xml");
        Person person = (Person) context.getBean("person");
        person.playWithAnimal();
    }
}
