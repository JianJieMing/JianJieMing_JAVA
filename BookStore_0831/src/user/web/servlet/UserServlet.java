package user.web.servlet;

import user.bean.UserBean;
import user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/register")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if ("".equals(username) || username == null || username.trim().equals("")) {
            request.setAttribute("msg", "用户名不能为空");
            request.getRequestDispatcher("/jsps/user/regist.jsp")
                    .forward(request, response);
            return;
        }
        String password = request.getParameter("password");
        if ("".equals(password) || password == null) {
            request.setAttribute("msg", "密码不能为空");
            request.getRequestDispatcher("/jsps/user/regist.jsp")
                    .forward(request, response);
            return;
        }
        String email = request.getParameter("email");
        if ("".equals(email) || email == null) {
            request.setAttribute("msg", "邮箱不能为空");
            request.getRequestDispatcher("/jsps/user/regist.jsp")
                    .forward(request, response);
            return;
        }
        UserBean user = new UserBean();
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        try {
            String regist = userService.regist(user);
            if (regist == null) {
                request.setAttribute("msg", "注册成功");
                request.getRequestDispatcher("/jsps/msg.jsp")
                        .forward(request, response);
                return;
            }
            request.setAttribute("msg", regist);
            request.getRequestDispatcher("/jsps/user/regist.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
