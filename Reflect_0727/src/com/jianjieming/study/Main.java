package com.jianjieming.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        /*
            反射
         */
        /*
            由什么组成一个类:
                构造方法
                修饰符
                类名
                属性
                方法

            由什么组成一个属性:
                数据类型
                修饰符
                变量名
                初始值

            由什么组成构造方法
                修饰符
                方法名
                参数

            由什么组成方法
                修饰符
                返回值
                方法名
                参数

         */

        /*
            存在任意一个类 P,
            P.class 代表获取到一个Class类的对象,
            该对象保存了P类的所有信息.
         */


//        获取某个属性的值,前提是对象得存在.
        Person p = new Person();

        Class<Person> personClass = Person.class;
//        有的时候,有的是某个类的对象.
        Class clazz = p.getClass();
//        类的全名
        System.out.println(clazz.getName());
//        类的简称
        System.out.println(clazz.getSimpleName());
//        获取类加载器
//        ClassLoader classLoader = clazz.getClassLoader();
//        System.out.println(classLoader);
        try {
//        有的时候,既没有类也没有对象,但是知道类名.
            Class ciazz2 = Class.forName("com.jianjieming.study.Person");
//            创建一个类的对象.前提是存在默认的构造方法.
            Object o = ciazz2.newInstance();
//            获取一个类的所有方法.
            Method[] methods = ciazz2.getDeclaredMethods();
//            获取一个参数的eat方法.
            Method eat = ciazz2.getDeclaredMethod("eat", String.class);
//            把方法设置成可访问的,防止私有化.
            eat.setAccessible(true);
            Object result = eat.invoke(o, "吃猫粮");
//            System.out.println(result);


        } catch (Exception e) {
            e.printStackTrace();
        }


//        获取某个类的所有属性.
        Field[] fields = personClass.getDeclaredFields(); // 获取自己的所有属性.
//        获取自己及父类的所有public的属性.
//        Field[] fields1 = personClass.getFields(      );
        Field f1 = fields[0];
        System.out.println(f1.getType().getName());
        System.out.println(f1.getName() + "**********");
//        获取属性的修饰符
        int m1 = f1.getModifiers();
        System.out.println(Modifier.toString(m1));
//        设置该属性为可访问的.
        f1.setAccessible(true);
//        p.name = "王小二";
        try {
//            通过反射修改某个对象的某个属性的值.
            f1.set(p,"张三");
//            System.out.println(p.name);

//        通过反射读取某个属性的值.
//            相当于 p.name
            Object o = f1.get(p);
            System.out.println(o);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        获取所有构造方法
        Constructor[] constructors = clazz.getConstructors();
        try {
//            获取一个构造方法
            Constructor<Person> constructor = clazz.getConstructor();
//            利用构造方法创建对象
            Person person = constructor.newInstance();
//            获取带参数的构造方法
            Constructor<Person> constructor1 = clazz.getConstructor(String.class);
            Person p1 = constructor1.newInstance("王五");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
