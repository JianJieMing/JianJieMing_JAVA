package com.lanou3g.netctoss.amendPassword.controller;

import com.lanou3g.netctoss.amendPassword.controller.parmens.PasswordParmens;
import com.lanou3g.netctoss.amendPassword.service.AmendPasswordService;
import com.lanou3g.netctoss.entity.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class AmendPasswordController {

    @Autowired
    private AmendPasswordService amendPassword;

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public AdminInfo updatePassword(@RequestBody PasswordParmens parmens, HttpServletRequest request) {
        // 从前端接收新密码,旧密码,根据旧密码和登录时session里的code查询这个用户
        HttpSession session = request.getSession();
        String adminCode = (String) session.getAttribute("adminCode");
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setPassword(parmens.getOldPassword());
        adminInfo.setAdminCode(adminCode);
        AdminInfo adminInfo1 = amendPassword.selectPassword(adminInfo);
        // 根据上面查出来的用户code,去更新他的密码
        AdminInfo adminInfo2 = new AdminInfo();
        adminInfo2.setAdminCode(adminInfo1.getAdminCode());
        adminInfo2.setPassword(parmens.getNewPassword());
        amendPassword.modifyPassword(adminInfo2);
        return adminInfo1;
    }

}