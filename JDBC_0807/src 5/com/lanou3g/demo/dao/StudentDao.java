package com.lanou3g.demo.dao;

import com.lanou3g.demo.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    Student findById(int stuId);

}
