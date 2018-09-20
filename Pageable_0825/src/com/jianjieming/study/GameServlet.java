package com.jianjieming.study;

import com.google.gson.Gson;
import com.jianjieming.study.common.ResultWrapper;
import com.jianjieming.study.controller.GameController;
import com.jianjieming.study.controller.GameControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */
@WebServlet(name = "GameServlet", urlPatterns = "/game.json")
public class GameServlet extends HttpServlet {
    private GameController gameController;

    @Override
    public void init() throws ServletException {
        gameController = new GameControllerImpl();
    }

    // 后台接收到前端发送过来的分页参数之后需要做什么?

    /*
        1. 接收前端传送过来的数据,String 类型.
        2. 如果没有值,则给page和count一个默认值.
        3. 把String转化为int类型.
        4. 根据page 和count计算出对应的limit两个值.(page-1 * count)
        5. 查询数据库的数据总数.
        6. 查询数据库分页的数据.
        7. 整合数据,转成json,返回给前端.
     */


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
//        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");


        int page, count;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }

        try {
            count = Integer.parseInt(request.getParameter("count"));
        } catch (Exception e) {
            count = 20;
        }

//        GameController gameController = new GameControllerImpl();
        ResultWrapper result = gameController.findGames(page, count);
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        gson.toJson(result, writer);
        writer.close();

    }
}
