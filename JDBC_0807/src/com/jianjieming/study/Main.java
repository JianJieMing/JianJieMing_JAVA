package com.jianjieming.study;

import com.jianjieming.dao.StudentDao;
import com.jianjieming.dao.impl.StudentDaoImpl;
import com.jianjieming.entity.Student;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author 铭
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> all = studentDao.findAll();
        System.out.println(all);

        Student student = studentDao.findById(4);
        System.out.println(student);
    }
}
