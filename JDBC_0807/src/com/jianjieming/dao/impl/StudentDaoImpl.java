package com.jianjieming.dao.impl;

import com.jianjieming.dao.StudentDao;
import com.jianjieming.entity.Student;
import com.jianjieming.utils.DBUtils;
import com.jianjieming.utils.ResultHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
//        DriverManager.registerDriver(new Driver());
        String sql = "select * from Student";
        return DBUtils.execute(sql, new StudentQueryRun());
    }

    @Override
    public Student findById(int stuId) {
        String sql = "select * from Student where SID = " + stuId;
        return DBUtils.execute(sql, new StudentQueryRun()).get(0);
    }


    private class StudentQueryRun implements ResultHandler {
        @Override
        public List<Student> handle(Statement st, String sql) throws SQLException {
            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("SID");
                String name = resultSet.getString("Sname");
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


//            String sql = "select * from Student";
//            statement.handle("DROP TABLE tb_code");
            /*
                handle: 可以执行任何SQL语句,但是常用来执行DDL,返回值是布尔类型.
                executeUpdate(): 只能执行DML语句,insert/update/delete
                                 返回值是int类型: 影响了几条数据.
                executeQuery(): 只能执行DQL语句,select

                resultSet.next(): 可以让游标下移一行.
                resultSet.get
             */
//            DriverManager.registerDriver(new Driver());
//            Properties p = new Properties();
//            p.setProperty("user","root");
//            p.setProperty("password","root");
//            Connection conn = DriverManager.getConnection(
//                    URL_MYSQL,
//                    p
//            );
//            Connection conn = DBUtils.getConnection();
//            Statement statement = conn.createStatement();