package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */

public class LogiServlet extends HttpServlet {

    /*
        HttpServlet 封装了Http协议
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 专门处理前端发送过来的get请求
        // 为了让前端浏览器可以正常显示汉字.
        // 需要告知浏览器汉字的编码格式.
        // 此信息需要保存在响应头中.
        // 注意: 必须在获取输出流之前设置响应头.

        // 设置响应头信息.
        // resp.setHeader(); 一个key只能对应一个value
        // resp.addHeader(); 一个key可以对应多个value

        // 设置编码格式 响应头的key是固定的,为Content-Type
        // 告知浏览器,响应数据为文本类型,html格式,编码为utf-8
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

//        resp.setContentType("text/html;charset=UTF-8");
//        resp.setCharacterEncoding("utf8");
//        req.setCharacterEncoding("utf8");
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>你好啊</h1>");
        pw.write("<h1>啛啛喳喳</h1>");
        pw.write("<h1>会撒娇客服还素</h1>");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
