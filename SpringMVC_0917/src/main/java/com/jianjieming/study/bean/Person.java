package com.jianjieming.study.bean;

import org.springframework.stereotype.Component;

/**
 * @author 铭
 * DATE: 18/9/17 下午3:30
 */
@Component("xxx")
public class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
