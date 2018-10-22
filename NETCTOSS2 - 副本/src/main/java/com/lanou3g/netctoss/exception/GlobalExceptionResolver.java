package com.lanou3g.netctoss.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//全局异常处理器
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String message = ex.getMessage();

        if (ex instanceof  JspException){
            mv.setViewName("error");
            mv.addObject("error",message);
        }else if (ex instanceof JsonException){
            // 返回Json格式的错误信息
            JsonException je = (JsonException) ex;
            int code = je.getCode();
            mv.setView(new  MappingJackson2JsonView());
            mv.addObject("code",code);
            mv.addObject("status",false);
            mv.addObject("message",message);
        }else {
            mv.setViewName("error");
            mv.addObject("error","服务器出错了");
        }
        return mv;
    }
}
