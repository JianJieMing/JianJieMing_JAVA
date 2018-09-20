package com.jianjieming.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/30 上午11:34
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // 设置文本类型.
        resp.setContentType("text/html;charset=UTF-8");
        // 设置响应的编码格式.
        resp.setCharacterEncoding("utf8");
        // 设置请求体中文本的编码格式.
        req.setCharacterEncoding("utf8");

        filterChain.doFilter(req, resp);
    }
}
