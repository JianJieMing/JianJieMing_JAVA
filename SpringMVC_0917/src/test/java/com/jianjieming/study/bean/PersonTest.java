package com.jianjieming.study.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author 铭
 * DATE: 18/9/17 下午3:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-web.xml")
public class PersonTest {
    @Autowired
    private Person person;

    @Test
    public void test() {
        System.out.println(person);
    }

}