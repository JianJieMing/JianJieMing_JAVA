package com.jianjieming.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "ImageServlet", urlPatterns = "/image/ss.jpg")
public class ImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        String image;
        if (referer == null || !referer.contains("localhost")) {
            image = "WEB-INF/image/ff.jpg";
        } else {
            image = "WEB-INF/image/ss.jpg";
        }
        response.setContentType("image/jpg");
        ServletContext context = getServletContext();
        String path = context.getRealPath(image);
        FileInputStream fis = new FileInputStream(path);
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = -1;
        while ((length = fis.read(bytes)) != -1) {
            os.write(bytes, 0, length);
        }
        os.close();
        fis.close();
    }
}
