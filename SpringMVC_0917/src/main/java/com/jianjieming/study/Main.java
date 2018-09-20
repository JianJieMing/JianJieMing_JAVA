package com.jianjieming.study;

import com.jianjieming.study.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/17 下午3:21
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-web.xml");
        Person p = (Person) context.getBean("xxx");
        System.out.println(p);
    }
}
