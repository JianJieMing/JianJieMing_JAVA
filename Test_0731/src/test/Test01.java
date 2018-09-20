package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JianJieMing",
                    "root",
                    "123456");
            Statement statement = conn.createStatement();
            String sql = "select * from Teacher";
            ResultSet resultSet = statement.executeQuery(sql);
            Student student = new Student();
            while (resultSet.next()) {
                String tid = resultSet.getString("TID");
                String tname = resultSet.getString("Tname");
                System.out.println(tid);
                System.out.println(tname);
                student.setName(tname);
                student.setId(Integer.parseInt(tid));
                System.out.println(student.getName() + student.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
