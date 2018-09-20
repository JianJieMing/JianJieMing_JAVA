package com.jianjieming.sping.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 铭
 * DATE: 18/9/11 上午11:43
 */
public class TestDog {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        dog.bark();
        // 在学习框架之前,使用javaEE技术,java代码进行实例化对象.
        // spring框架,通过配置文件实例化对象.


        // 打开容器,调用接口.
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        // getBean(),参数是在配置文件里面设置的id,String类型.
        // 返回值是Object类型,想要获得任意类型,需要做强转.
        Dog dog = (Dog) context.getBean("dog");
        dog.bark();

        Paper paper = (Paper) context.getBean("paper");
        paper.testPaper();
        Paper paper2 = (Paper) context.getBean("paper2");
        paper2.testPaper();
        Paper paper3 = (Paper) context.getBean("paper3");
        paper3.testPaper();

    }
}
