package com.jianjieming.src.com.lanou3g.demo;

import com.lanou3g.demo.e3.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class E3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(60, "张三1", 15));
        students.add(new Student(25, "张2", 17));
        students.add(new Student(58, "张3", 11));
        students.add(new Student(30, "张4", 18));
        students.add(new Student(56, "张三5", 11));
        students.add(new Student(72, "张6", 19));
        students.add(new Student(63, "张7", 14));

        students.stream()
                .filter((stu) -> stu.getNo() > 50 && stu.getName().length() == 2)
                .map(Student::getAge)
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------");
        List<Integer> ages = new ArrayList<>();
        for (Student stu : students) {
            if (stu.getNo() > 50 && stu.getName().length() == 2){
                ages.add(stu.getAge());
            }
        }
        Collections.sort(ages);
        for (Integer age : ages) {
            System.out.println(age);
        }

    }
}
