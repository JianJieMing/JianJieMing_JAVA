package com.lanou3g.demo.utils;

import com.lanou3g.demo.entity.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface SqlRunnable {

    List<Student> execute(Statement st, String sql) throws SQLException;

}
