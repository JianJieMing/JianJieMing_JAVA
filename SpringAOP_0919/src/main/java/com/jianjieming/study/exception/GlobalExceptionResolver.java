package com.jianjieming.study.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 在Spring项目执行过程中,抛出了某个异常
        // 而这个异常,没有进行处理,没有try...catch
        // 那么最终这个异常会传递到该方法中
        // 对异常做某个判断之后,可以返回特定的ModelAndView
        // 方法的参数中的Exception对象,就是抛出的异常对象
        ModelAndView mv = new ModelAndView();
        String message = ex.getMessage();
        if (ex instanceof JspException) {
            mv.setViewName("error");
            mv.addObject("error", message);
        } else if (ex instanceof JsonException) {
            // 返回Json格式的错误信息
            JsonException je = (JsonException) ex;
            int code = je.getCode();
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("code", code);
            mv.addObject("status", false);
            mv.addObject("message", message);
        } else {
            mv.setViewName("error");
            mv.addObject("error","服务器出错");
        }
        return mv;
    }
}
