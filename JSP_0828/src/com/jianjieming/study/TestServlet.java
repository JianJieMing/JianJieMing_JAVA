//package com.jianjieming.study;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * @author 铭
// * DATE: 18/8/31 上午8:16
// */
//@WebServlet(name = "TestServlet", urlPatterns = "/test")
//public class TestServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("utf8");
//        request.setCharacterEncoding("utf8");
//
//        HttpSession session = request.getSession();
//        Boolean flag = (Boolean) session.getAttribute("flag");
//        if (flag) {
//            request.getRequestDispatcher("WEB-INF/hint.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("WEB-INF/hint.jsp").forward(request, response);
//        }
//
//    }
//}
