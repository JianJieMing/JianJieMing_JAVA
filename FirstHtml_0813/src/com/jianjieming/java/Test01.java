package com.jianjieming.java;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.FileWriter;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        String s2 = "<tr>";
        String s3 = "<td>";
        String s4 = "</tr>";
        String s5 = "</td>";
        String s6 = "</table>";
        String s7 = "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"1\" width=\"50%\">\n" +
                "    <caption>成绩表</caption>";
        String s8 = "</body>\n" +
                "</html>";
        String s9 = "<thead>";
        String s10 = "</thead>";
        String s11 = "<tbody>";
        String s12 = "</tbody>";
        try {
            FileWriter fw = new FileWriter("User.html");
            String url = "";
            String sql = "select * from User";
            Connection conn = cpds.getConnection();
            List<User> userList = runner.query(conn, sql, new BeanListHandler<>(User.class, new UnderlineProcessor()));
            StringBuilder sb = new StringBuilder();
            sb.append(s7)
                    .append(s9).append(s2).append(s3).append("用户名")
                    .append(s5).append(s3).append("密码")
                    .append(s5).append(s3).append("爱好")
                    .append(s5).append(s4).append(s10).append(s11);
            for (User user : userList) {
                sb.append(s2)
                        .append(s3).append(user.getuUsername()).append(s5)
                        .append(s3).append(user.getuPassword()).append(s5)
                        .append(s3).append(user.getuWord()).append(s5)
                        .append(s4);
            }
            sb.append(s12).append(s6).append(s8);
            fw.write(sb.toString());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
