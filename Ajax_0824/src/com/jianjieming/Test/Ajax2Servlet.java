package com.jianjieming.Test;

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
@WebServlet(name = "Ajax2Servlet", urlPatterns = "/ajax2")
public class Ajax2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Map map = new Gson().fromJson(reader, Map.class);
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.get("introduce"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf8");
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "张三" + i);
            map.put("age", i);
            map.put("number", "00" + i);
            mapList.add(map);
        }
        PrintWriter writer = response.getWriter();
        String s = new Gson().toJson(mapList);
        writer.println(s);
        writer.close();

    }
}
