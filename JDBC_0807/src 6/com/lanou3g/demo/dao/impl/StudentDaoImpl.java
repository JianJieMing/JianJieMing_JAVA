package com.lanou3g.demo.dao.impl;

import com.lanou3g.demo.dao.StudentDao;
import com.lanou3g.demo.entity.Student;
import com.lanou3g.demo.utils.DBUtils;
import com.lanou3g.demo.utils.ResultHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
//        DriverManager.registerDriver(new Driver());
        String sql = "select * from t_students";
        return DBUtils.execute(sql, new StudentHandler());
    }

    @Override
    public Student findById(int stuId) {
        String sql = "select * from t_students where stu_id = " + stuId;
        return DBUtils.execute(sql, new StudentHandler()).get(0);
    }

    private static class StudentHandler implements ResultHandler<Student>{

        @Override
        public List<Student> handle(Statement st, String sql) throws SQLException {
            // 4. 执行SQL
            // 共同点: 都是执行SQL语句的
            // handle: 可以执行任何SQL语句, 但是常用来执行DDL
//            st.handle("drop table tb_code");
            // executeUpdate: 只能用来执行DML语句, insert/update/delete
            // 返回值int类型: 影响了几条数据
//            st.executeUpdate()
            // executeQuery: 只能执行DQL语句, select
            // 返回值ResultSet类型: 结果集

//            DAO  data access object
            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new ArrayList<>();
//            boolean resultSet.next() 可以让游标下移一行
            while (resultSet.next()) {
                int id = resultSet.getInt("stu_id");
                String name = resultSet.getString("stu_name");
                Date date = resultSet.getDate(3);
                String gender = resultSet.getString(4);
                Student stu = new Student(id, name, date, gender);
                students.add(stu);
//                System.out.print(id + "\t");
//                System.out.print(name + "\t");
//                System.out.print(date + "\t");
//                System.out.print(gender + "\n");
            }
            resultSet.close();
            return students;
        }
    }


}
