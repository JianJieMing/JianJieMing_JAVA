package dao;

import entity.Student;
import utils.DBUtil;
import utils.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
        String sql = "select * from Student";
        return DBUtil.execute(sql, new StudentHandler());
    }

    @Override
    public Student findById(int stuId) {
        String sql = "select * from Student where SID = " + stuId;
        return DBUtil.execute(sql, new StudentHandler()).get(0);
    }

    public static class StudentHandler implements ResultHandler<Student> {

        @Override
        public List<Student> handle(Statement st, String sql) throws SQLException {
            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("SID");
                String name = resultSet.getString("Sname");
                java.sql.Date date = resultSet.getDate(3);
                String gender = resultSet.getString(4);
                Student stu = new Student(id, name, date, gender);
                students.add(stu);
            }
            resultSet.close();
            return students;
        }
    }

}
