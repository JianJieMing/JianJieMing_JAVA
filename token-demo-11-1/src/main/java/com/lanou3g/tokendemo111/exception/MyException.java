package com.lanou3g.tokendemo111.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * 2018/11/1 17:41
 */
@Component
public class MyException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof NullPointerException) {
            ModelAndView mv = new ModelAndView();
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("status", false);
            mv.addObject("code", 666);
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        return null;
    }

}
