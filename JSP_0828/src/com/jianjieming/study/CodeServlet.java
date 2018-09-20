package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "CodeServlet",urlPatterns = "/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("image/png");
        ValidateCode code = new ValidateCode(200, 50, 4, 150);
        HttpSession session = request.getSession(true);
        String c = code.getCode();
        session.setAttribute("validateCode", c);
        ServletOutputStream os = response.getOutputStream();
        code.write(os);
        os.close();
    }
}
