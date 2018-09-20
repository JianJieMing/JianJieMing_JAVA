package com.lanou3g.demo.dao.impl;

import com.lanou3g.demo.config.DatabaseConfig;
import com.lanou3g.demo.dao.StudentDao;
import com.lanou3g.demo.entity.Student;
import com.lanou3g.demo.utils.DBUtils;
import com.lanou3g.demo.utils.SqlRunnable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
//        DriverManager.registerDriver(new Driver());
        String sql = "select * from t_students";
        return DBUtils.execute(sql, new StudentQueryRun());
    }

    @Override
    public Student findById(int stuId) {
        String sql = "select * from t_students where stu_id = " + stuId;
        return DBUtils.execute(sql, new StudentQueryRun()).get(0);
    }

    private class StudentQueryRun implements SqlRunnable{

        @Override
        public List<Student> execute(Statement st, String sql) throws SQLException {
            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("stu_id");
                String name = resultSet.getString("stu_name");
                Date date = resultSet.getDate(3);
                String gender = resultSet.getString(4);
                Student stu = new Student(id, name, date, gender);
                students.add(stu);
            }
            resultSet.close();
            return students;
        }
    }

}
