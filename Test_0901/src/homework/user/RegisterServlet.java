package homework.user;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import homework.bean.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author 铭
 * DATE: 18/9/1 上午10:35
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        ComboPooledDataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        try {
            Connection conn = ds.getConnection();
            String insertUser = "insert into user (username,password) values (?,?)";
            if (username != null && password != null) {
                Object[] user = {username, password};
                runner.insert(conn, insertUser, new BeanListHandler<>(User.class), user);
                DbUtils.close(conn);
                response.sendRedirect("/login.jsp");
            } else {
                response.getWriter().write("<h1>很遗憾注册失败</h1><br><a href=\"register.jsp\" style=\"text-decoration: none\"><input type=\"button\" value=\"返回注册界面\"></a>\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
