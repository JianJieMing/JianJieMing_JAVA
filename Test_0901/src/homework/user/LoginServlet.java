package homework.user;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import homework.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/1 上午10:32
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ComboPooledDataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();

        try {
            Connection conn = ds.getConnection();
            String queryUser = "select username,password from user";
            List<User> userList = runner.query(conn, queryUser, new BeanListHandler<>(User.class));
            for (User user : userList) {
                String name = user.getUsername();
                String word = user.getPassword();
                if (username.equals(name) && password.equals(word)) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("username", username);
                    Cookie cookie = new Cookie("JSESSIONID", session.getId());
                    cookie.setMaxAge(60 * 10);
                    response.addCookie(cookie);
                    response.sendRedirect("/game-list.jsp");
                } else {
                    response.sendRedirect("register.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
