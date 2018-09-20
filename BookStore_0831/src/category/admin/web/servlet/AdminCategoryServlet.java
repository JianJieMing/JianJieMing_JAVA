//package category.admin.web.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "AdminCategoryServlet", urlPatterns = "/admin-servlet")
//public class AdminCategoryServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String adminname = request.getParameter("adminname");
//        String password = request.getParameter("password");
//        if ("admin".equals(adminname) && "admin".equals(password)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("adminname", adminname);
//            request.getRequestDispatcher("/adminjsps/admin/main.jsp").forward(request, response);
//        } else {
//            response.sendRedirect("/adminjsps/login.jsp");
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
