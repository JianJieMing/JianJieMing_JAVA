package com.jianjieming.study;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 铭
 */
@WebServlet(name = "AjaxServlet", urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        // 把前端ajax发送过来的json数据转成map并且输出
        Map map = new Gson().fromJson(br, Map.class);
        System.out.println("我是谁" + map.get("username"));
        System.out.println("我到底是谁" + map.get("password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password + "*********");

        List<Map<String, Object>> data = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap();
            map.put("id", 1 + i);
            map.put("name", "张三" + i);
            map.put("age", 18 + i);
            data.add(map);
        }

        // 将数据转成json格式发给ajax前端
        String s = new Gson().toJson(data);
        out.println(s);
        out.close();


    }
}
