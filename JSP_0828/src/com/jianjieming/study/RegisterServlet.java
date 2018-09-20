package com.jianjieming.study;

import com.jianjieming.bean.HeaderImageBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register.action")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取项目的路径.
        ServletContext app = getServletContext();

        String dirPath = app.getRealPath("header-images");
        FileUtils.forceMkdir(new File(dirPath));
        String hint1 = "<h1>恭喜你注册成功</h1><br><a href=\"../login.html\" style=\"text-decoration: none\"><input type=\"button\" value=\"前往登录界面\"></a>\n";
        String hint2 = "<h1>很遗憾注册失败</h1><br><a href=\"../register.html\" style=\"text-decoration: none\"><input type=\"button\" value=\"返回注册界面\"></a>\n";

        // gerParameter 只能取请求头中Context-Type
        // 值为: application/x-www-form-urlencoded 的请求的参数.
        // 或者是url后面拼接的数据
        // 说的直白一点: name=xxx&password=yyy&age=10

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload up = new ServletFileUpload(factory);
        up.setHeaderEncoding("utf-8");
        up.setFileSizeMax(2 * 1024 * 1024);
        up.setSizeMax(5 * 1024 * 1024);
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = null;
        File image = null;
        try {
            conn = ds.getConnection();
            // 解析文件,根据----分为几部分.
            List<FileItem> fileItems = up.parseRequest(req);
            HeaderImageBean header = new HeaderImageBean();
            Map<String, String> map = new HashMap<>();
            for (FileItem item : fileItems) {
                if (item.isFormField()) {
                    // 如果是普通表单 先取出key值.
                    String key = item.getFieldName();
                    // 取出value值.
                    String value = item.getString("utf-8");
//                反射写法    Class<? extends UserBean> clazz = user.getClass();
//                    Field f = clazz.getDeclaredField(key);
//                    f.set();
                    // 把key和value放入map集合中.
                    map.put(key, value);
                } else {
                    // 说明上传的是文件
                    if ("headerImg".equals(item.getFieldName())) {
                        // 接收用户上传的头像文件
                        // image/png img/jpg
                        if (item.getContentType().startsWith("image")) {

                            String imageName = item.getName();
                            String imageType = item.getContentType();

                            String uuid = UUID.randomUUID().toString();
                            image = new File(dirPath, uuid);
                            item.write(image);

                            String imagePath = image.getAbsolutePath();
                            header.setImageName(imageName);
                            header.setImageType(imageType);
                            header.setImagePath(imagePath);
                        }
                    }
                }
            }

            // 把数据存储到数据库
            // 关闭事务的自动提交
            conn.setAutoCommit(false);
            // 对两次输入的密码进行一致性的校验
            String pwd = map.get("password");
            System.out.println(pwd);
            System.out.println(map.get("repeat"));
            System.out.println("*********");
            if (pwd == null || !pwd.equals(map.get("repeat"))) {
                throw new IllegalAccessException("两次密码不一致");
            }

            String imgInsert =
                    "insert into t_header_image (image_name, image_type, image_path) value(?,?,?)";
            Object[] imgValues = {
                    header.getImageName(),
                    header.getImageType(),
                    header.getImagePath()
            };

            QueryRunner runner = new QueryRunner();
            // 插入数据之后, 获取生成的id
            Long id = runner.insert(conn, imgInsert, new ScalarHandler<Long>(1), imgValues);
            String userInsert = "insert into t_user (image_id,username,password)value(?,?,?)";
            Object[] userValues = {
                    id, map.get("username"),
                    map.get("password")
            };
            runner.update(conn, userInsert, userValues);
            // 提交事务
            DbUtils.commitAndCloseQuietly(conn);
//            conn.commit();
            req.setAttribute("hint", hint1);
            req.getRequestDispatcher("WEB-INF/hint.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // 如果出现异常, 把用户上传的文件删除
            if (image != null) {
                image.delete();
            }
            // 回滚事务
            DbUtils.rollbackAndCloseQuietly(conn);
            req.setAttribute("hint", hint2);
            req.getRequestDispatcher("WEB-INF/hint.jsp").forward(req, resp);
//            try {
//                conn.rollback();
//            } catch (SQ LException e1) {
//                e1.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
