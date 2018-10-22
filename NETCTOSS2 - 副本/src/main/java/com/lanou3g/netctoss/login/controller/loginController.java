package com.lanou3g.netctoss.login.controller;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.entity.AdminInfoQx;
import com.lanou3g.netctoss.login.service.AdminInfoService;
import com.lanou3g.netctoss.utils.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/admin")
public class loginController {

    @Autowired
    private AdminInfoService adminInfoService;

    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        ValidateCode code = new ValidateCode(100, 40, 4, 10);
        String code1 = code.getCode();
        HttpSession session = request.getSession(true);
        session.setAttribute("validateCode", code1);
        ServletOutputStream outputStream = response.getOutputStream();
        code.write(outputStream);
        outputStream.close();
    }


    @ResponseBody
    @RequestMapping(value = "/login")
    public AdminInfo login(AdminInfo adminInfo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String validateCode = (String) session.getAttribute("validateCode");
        String code = request.getParameter("code");

        AdminInfo adminInfo1 = adminInfoService.findOne(adminInfo);
        String adminCode = adminInfo1.getAdminCode();
        if (adminInfo1 == null) {
            return new AdminInfo();
        } else if (!validateCode.equalsIgnoreCase(code)) {
            return null;
        }
        session.setAttribute("adminCode", adminCode);
        return adminInfo1;
    }

    @RequestMapping("/showModule")
    public String showModule(  HttpServletRequest request) {
        HttpSession session = request.getSession();
        String adminCode1 = (String) session.getAttribute("adminCode");
        AdminInfoQx adminInfoQxes = adminInfoService.showModule(adminCode1);
        session.setAttribute("adminInfoQxes",adminInfoQxes);
        return "/index";
    }

}
