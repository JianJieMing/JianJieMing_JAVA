package com.lanou3g.netctoss.information.controller;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.information.controller.params.AdminInfoImpl;
import com.lanou3g.netctoss.information.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/informationcontroller")
public class InformationController {
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(AdminInfo adminInfo,HttpSession session) {
        String adminCode = (String) session.getAttribute("adminCode");
        adminInfo.setAdminCode(adminCode);
        informationService.modify(adminInfo);
        return "redirect:/user/a.jsp";
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public String selectAll(HttpSession session, Model model) {
        AdminInfo adminInfo = new AdminInfo();
        String adminCode = (String) session.getAttribute("adminCode");
        adminInfo.setAdminCode(adminCode);
        AdminInfoImpl adminInfo1 = informationService.selectAll(adminInfo);
        model.addAttribute("adminInfo1", adminInfo1);
        return "/user/user_info";
    }

}
