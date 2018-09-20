package com.lanou3g.demo;

import com.lanou3g.demo.dao.StudentDao;
import com.lanou3g.demo.dao.impl.StudentDaoImpl;
import com.lanou3g.demo.dao.impl.StudentDaoImplTest;
import com.lanou3g.demo.entity.Student;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDao stuDao = new StudentDaoImpl();
        List<Student> studentList = stuDao.findAll();

        Student stu = stuDao.findById(3);
        System.out.println(stu);


    }
}
