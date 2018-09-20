package admin.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 后台登录
 *
 * @author 铭
 * DATE: 18/8/31 下午7:46
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = "/admin.login")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");

        if ("admin".equalsIgnoreCase(adminname) && "admin".equalsIgnoreCase(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", adminname);
            response.sendRedirect("adminjsps/admin/index.jsp");
        } else {
            response.getWriter().write("<a href=\"adminjsps/login.jsp\" style=\"text-decoration: none;color: red\"><h1>用户名或者密码不正确,点我返回上一层</h1></a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
