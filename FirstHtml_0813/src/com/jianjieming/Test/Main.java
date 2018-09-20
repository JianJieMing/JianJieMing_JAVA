package com.jianjieming.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge(123456);
        Message message = new Message();
        message.setPersonal("张三李四王五赵六田七");
        student.setMessage(message);
//        for (int i = 1234; i < 1238; i++) {
        Student student1 = (Student) student.clone();
        student1.setAge(3124214);
//            student1.setAge(i);
//            student1.setMessage(message);
//            students.add(student1);
//        }
        message.setPersonal("孙风刘雨赵雷钱电");
        System.out.println("原本的对象" + student);
        System.out.println("克隆的对象" + student1);
//        for (Student student1 : students) {
//            System.out.println(student1);
//        }
    }
}
