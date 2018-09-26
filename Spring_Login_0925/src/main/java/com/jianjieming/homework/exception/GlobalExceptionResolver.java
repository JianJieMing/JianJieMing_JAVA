package com.jianjieming.homework.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * 2018/9/25 9:55
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String message = ex.getMessage();
        if (ex instanceof JsonException)   {
            JsonException je = (JsonException) ex;
            int code = je.getCode();
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("code", code);
            mv.addObject("status", false);
            mv.addObject("message", message);
        } else {
            mv.setViewName("error");
            mv.addObject("error", "服务器出错");
        }
        return mv;
    }
}
