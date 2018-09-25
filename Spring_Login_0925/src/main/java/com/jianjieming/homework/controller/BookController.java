package com.jianjieming.homework.controller;

import com.jianjieming.homework.bean.UserBean;
import com.jianjieming.homework.exception.JsonException;
import com.jianjieming.homework.rule.LoginRule;
import com.jianjieming.homework.rule.RegisterRule;
import com.jianjieming.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 铭
 * 2018/9/25 10:23
 */
@Controller
public class BookController {
    @Resource
    private UserService userService;

    @RequestMapping("/test1")
    public String test1() {
        return "login";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "register";
    }

    @RequestMapping("/test3")
    public String test3() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@Validated(value = {LoginRule.class}) UserBean userBean,
                        BindingResult result,
                        HttpServletRequest request,
                        Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<UserBean> beans = userService.showAll();
        if (result.hasErrors()) {
            // 获取所有属性的所有校验错误信息.
            List<FieldError> errors = result.getFieldErrors();
            // 如果出错,把错误集合放到Model中
            model.addAttribute("errors", errors);
            for (FieldError error : errors) {
                String message = error.getDefaultMessage();
                System.out.println(message);
            }
            return "error";
        } else {
            for (UserBean bean : beans) {
                if (username.equals(bean.getUsername()) && password.equals(bean.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    return "main";
                } else {
                    model.addAttribute("error", "用户名或者密码不正确");
                    throw new JsonException("用户名密码不正确异常", 400);
                }
            }
            return "";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@Validated(value = {LoginRule.class, RegisterRule.class}) UserBean userBean, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            // 获取所有属性的所有校验错误信息.
            List<FieldError> errors = result.getFieldErrors();
            // 如果出错,把错误集合放到Model中
            model.addAttribute("errors", errors);
            for (FieldError error : errors) {
                String message = error.getDefaultMessage();
                System.out.println(message);
            }
            return "error";
        }
        return "login";
    }
}
