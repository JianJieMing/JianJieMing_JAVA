package com.jianjieming.study;

import com.jianjieming.utils.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用来生成验证码图片的Servlet
 *
 * @author 铭
 */
@WebServlet(name = "ValidateServlet", urlPatterns = "/code")
public class ValidateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        ValidateCode code = new ValidateCode(160, 30, 4, 150);
        String c = code.getCode();
        // true代表如果没有Sessionid则创建一个.
        HttpSession session = request.getSession(true);
        session.setAttribute("validateCode", c);
        ServletOutputStream os = response.getOutputStream();
        code.write(os);
        os.close();
    }
}
