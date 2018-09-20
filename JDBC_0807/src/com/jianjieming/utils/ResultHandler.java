package com.jianjieming.utils;

import com.jianjieming.entity.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 铭
 */
public interface ResultHandler {

    List<Student> handle(Statement st, String sql) throws SQLException;

}
