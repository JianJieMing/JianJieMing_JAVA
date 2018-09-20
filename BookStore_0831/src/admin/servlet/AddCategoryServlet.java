package admin.servlet;

import admin.dao.impl.CategoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加分类
 * @author 铭
 * DATE: 18/9/7 下午5:16
 */
@WebServlet(name = "AddCategoryServlet", urlPatterns = "/addCategory")
public class AddCategoryServlet extends HttpServlet {

    private CategoryImpl category = new CategoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        if (!cname.equals("") && cname.length() > 0 && !cname.trim().equals("")) {
            category.addClassify(cname);
            request.setAttribute("cname", cname);
            response.sendRedirect("/adminjsps/admin/category/list.jsp");
        } else {
            String msg;
            msg = "分类名字不能为空";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
        }
    }
}
