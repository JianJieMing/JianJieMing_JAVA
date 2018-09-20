package dao;

import entity.Student;

import java.util.List;

/**
 * @author 铭
 */
public interface StudentDao {

    List<Student> findAll();

    Student findById(int stuId);

}
