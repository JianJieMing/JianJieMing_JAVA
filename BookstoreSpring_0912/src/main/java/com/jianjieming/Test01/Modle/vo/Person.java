package com.jianjieming.Test01.Modle.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午7:56
 */
@Component
public class Person {
    @Value("张三")
    private String name;
    private List<Animal> animal;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", animal=" + animal +
                '}';
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
}
