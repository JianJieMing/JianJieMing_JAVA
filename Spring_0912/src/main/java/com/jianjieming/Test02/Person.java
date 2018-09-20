package com.jianjieming.Test02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 铭
 * DATE: 18/9/12 上午10:46
 */
// 使用该类实例化,Person person = new Person();
// Component(id值),如果()省略,默认值就是该类的首字母小写.
@Component("person") // 当所属的bean不在以下三层,或不明确的时候使用.
public class Person {
    // 原理就相当于<property name = "name" value = "李云">
    @Value(value = "李云")
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }


}
