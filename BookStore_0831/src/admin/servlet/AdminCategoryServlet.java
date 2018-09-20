package admin.servlet;

import admin.dao.impl.CategoryImpl;
import admin.domain.Category;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 查看所有分类
 *
 * @author 铭
 * DATE: 18/8/31 下午9:00
 */
@WebServlet(name = "AdminCategoryServlet", urlPatterns = "/adminCategory")
public class AdminCategoryServlet extends HttpServlet {

    private CategoryImpl category = new CategoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        List<Category> categories = category.selectClassify();
        String s = new Gson().toJson(categories);
        writer.println(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
