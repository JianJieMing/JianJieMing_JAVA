package com.lanou3g.demo.dao.impl;

import com.lanou3g.demo.dao.StudentDao;
import com.lanou3g.demo.entity.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplTest implements StudentDao {
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i + 1, "AAA", new Date(12934898234L), "男"));
        }
        return students;
    }

    @Override
    public Student findById(int stuId) {
        return null;
    }
}
