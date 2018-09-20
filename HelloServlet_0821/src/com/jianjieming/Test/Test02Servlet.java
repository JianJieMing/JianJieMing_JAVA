package com.jianjieming.Test;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "Test02Servlet", urlPatterns = "/test")
public class Test02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/Users/dllo/Desktop/sss.jpg";
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = IOUtils.toByteArray(fis);
        response.getOutputStream().write(bytes);
    }
}
