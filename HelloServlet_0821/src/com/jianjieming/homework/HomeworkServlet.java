package com.jianjieming.homework;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author 铭
 */
@WebServlet(name = "HomeworkServlet", urlPatterns = "/work")
public class HomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = URLEncoder.encode("Http协议", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + s + ".jpg");
//        InputStream is = getServletContext().getResourceAsStream("a.jpg");
//        response.setHeader("Content-Type", "image/jpg");
        response.setContentType("image/jpg");
        File file = new File("/Users/dllo/Desktop/sss.jpg");
        InputStream is = new FileInputStream(file);
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = -1;
        while ((length = is.read(bytes)) != -1) {
            os.write(bytes, 0, length);
        }
        os.close();
        is.close();
    }
}
