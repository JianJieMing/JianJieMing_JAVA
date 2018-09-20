package com.jianjieming.login;

import com.jianjieming.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        PrintWriter writer = response.getWriter();
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String sex = request.getParameter("sex");
        String dateISO = request.getParameter("dateISO");
        String url = request.getParameter("url");
        String email = request.getParameter("email");

//        String dirPath = getServletContext().getRealPath("files");
//        File file = new File(dirPath);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        ServletFileUpload up = new ServletFileUpload();
//        up.setFileItemFactory(new DiskFileItemFactory());
//        up.setHeaderEncoding("utf8");
//        up.setFileSizeMax(2 * 1024 * 1024);
//        up.setSizeMax(10 * 1024 * 1024);
//
//        UUID uuid2 = UUID.randomUUID();
//        String uuid = String.valueOf(uuid2).replace("-", "");
//        String path1 = "";
//        String path2 = "";
//        String path3 = "";

        String sql = "select username,password from User";
        String sql2 = "insert into User (username,password,sex,url,email,birth) values (?,?,?,?,?,?)";
//        String sql3 = "insert into U_image (image_id,image_name,image_type,image_path) values (?,?,?,?)";
//
        try {
            Connection conn = cpds.getConnection();
//            List<FileItem> fileItems = up.parseRequest(request);
//            for (FileItem item : fileItems) {
//                if (item.isFormField()) {
//                    continue;
//                }
//                File file1 = new File(dirPath, item.getName());
//                item.write(file1);
//                path1 = file1.getAbsolutePath();
//                System.out.println("绝对路径: " + path1);
//                path2 = file1.getName();
//                System.out.println("文件名称: " + path2);
//                path3 = path2.substring(path2.lastIndexOf(".") + 1);
//                System.out.println("文件后缀: " + path3);
//            }
//            Object[] imageList = {uuid, path2, path3, path1};
//            runner.insert(conn, sql3, new BeanListHandler<>(Image.class, new UnderlineProcessor()), imageList);

            List<User> query = runner.query(conn, sql, new BeanListHandler<>(User.class));
            for (User user : query) {
                if (username.equals(user.getUsername())) {
                    response.getWriter().write("<a href=\"register.html\" style=\"text-decoration: none;color: red\"><h1>用户名已存在,点我返回上一层</h1></a>");
                } else if (!username.equals(user.getUsername())) {
                    if (password1.equals(password2)) {
                        Object[] obj = {username, password2, sex, dateISO, url, email};
                        runner.insert(conn, sql2, new BeanListHandler<>(User.class), obj);
                        response.setHeader("refresh", "5;url=login.html");
                        response.getWriter().println("<a style=\"text-decoration: none;color: #ff0214\" href=\"login.html\"><h1>注册成功,5秒钟自动跳转到登录界面,否则点击前往</h1></a>");
                        DbUtils.close(conn);
                    } else {
                        writer.write("注册失败");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
