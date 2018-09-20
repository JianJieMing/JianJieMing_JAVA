package user.web.servlet;

import user.bean.UserBean;
import user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if ("".equals(username) || username == null) {
            request.setAttribute("msg", "用户名不能为空");
            request.getRequestDispatcher("/jsps/user/login.jsp")
                    .forward(request, response);
            return;
        }
        String password = request.getParameter("password");
        if ("".equals(password) || password == null) {
            request.setAttribute("msg", "密码不能为空");
            request.getRequestDispatcher("/jsps/user/login.jsp")
                    .forward(request, response);
            return;
        }
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        try {
            UserBean user1 = userService.login(user);
            if (user1 == null) {
                request.setAttribute("msg", "用户名不存在/密码错误");
                request.getRequestDispatcher("/jsps/user/login.jsp")
                        .forward(request, response);
            } else {
                request.getSession().setAttribute("user", user1);
                response.sendRedirect(request.getContextPath() + "/jsps/msg.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getSession().invalidate();
      response.sendRedirect("/jsps/user/login.jsp");
    }
}
