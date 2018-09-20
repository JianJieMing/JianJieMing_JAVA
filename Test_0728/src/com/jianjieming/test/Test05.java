package com.jianjieming.test;

import com.jianjieming.test.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 铭
 */
public class Test05 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<Person> personClass = Person.class;
//        得到所有的构造方法
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
//        得到俩参数的构造方法.
        Constructor<Person> c2 = personClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(c2);
//        获取普通方法
        Method string = personClass.getDeclaredMethod("eat",String.class);
        Method string2 = personClass.getDeclaredMethod("eat",String.class,int.class);
        System.out.println(string);
        System.out.println(string2);
//        获取类名
        String name = personClass.getName();
        System.out.println(name);

        Field[] df = personClass.getDeclaredFields();
        for (Field field : df) {
            field.setAccessible(true);
            System.out.println(field);
        }

        Field name1 = personClass.getDeclaredField("age");
        name1.set(person,33);
        Object o = name1.get(person);
        System.out.println(o);


    }
}
