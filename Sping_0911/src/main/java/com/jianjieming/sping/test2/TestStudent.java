package com.jianjieming.sping.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/11 下午4:00
 */
public class TestStudent {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
