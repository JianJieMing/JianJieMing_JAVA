package com.lanou3g.netctoss.admin.controller;

import com.lanou3g.netctoss.admin.controller.params.AdminParams;
import com.lanou3g.netctoss.admin.controller.params.AdminRoleParams;
import com.lanou3g.netctoss.admin.service.AdminService;
import com.lanou3g.netctoss.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 铭
 * 2018/10/10 8:32
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/admin_list.do", method = RequestMethod.GET)
    @ResponseBody
    public List<AdminInfoQx> queryAdminAndModule() {
        ModuleInfo moduleInfo = new ModuleInfo();
        List<AdminInfoQx> adminInfoQxes = adminService.queryAdminAndRole(moduleInfo);
        return adminInfoQxes;

    }

    @RequestMapping("/admin_list")
    public String queryModuleName(Model model) {
        List<ModuleInfo> moduleNames = adminService.queryModuleName();
        model.addAttribute("moduleNames", moduleNames);
        return "/admin/admin_list";
    }

    @RequestMapping(value = "/queryModule", method = RequestMethod.POST)
    @ResponseBody
    public List<AdminInfoQx> queryAdminAndModule(@RequestBody ModuleInfo moduleInfo) {
        List<AdminInfoQx> adminInfoQxes = adminService.queryAdminAndRole(moduleInfo);
        return adminInfoQxes;
    }

    @RequestMapping(value = "/queryRoleName",method = RequestMethod.POST)
    @ResponseBody
    public List<AdminInfoQx> queryRoleName(@RequestBody RoleInfo roleInfo) {
        List<AdminInfoQx> adminInfoQxes = adminService.queryRoleName(roleInfo);
        return adminInfoQxes;
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public String updatePassword(@RequestBody AdminParams adminParams){
        adminService.updatePassword(adminParams);
        return "admin/admin_list";
    }

    @RequestMapping(value = "/insertAdminRole",method = RequestMethod.POST)
    public String insertAdminAndAdminRole(@RequestBody AdminRoleParams adminRoleParams){
        adminService.insertAdminAndAdminRole(adminRoleParams);
        return "admin/admin_list";
    }

    @ResponseBody
    @RequestMapping(value = "/queryRoleInfoName",method = RequestMethod.GET)
    public List<RoleInfo> queryRoleInfoName(){
        List<RoleInfo> roleInfos = adminService.queryRoleInfoName();
        return roleInfos;
    }

    @RequestMapping(value = "/deleteAdminInfoAndAnminRole",method = RequestMethod.POST)
    public String deleteAdminInfoAndAnminRole(@RequestBody AdminInfo adminInfo){
        adminService.deleteAdminInfoAndAnminRole(adminInfo);
        return "admin/admin_list";
    }

    @RequestMapping(value = "/queryAdminInfo")
    @ResponseBody
    public AdminInfo queryAdminInfo(@RequestBody AdminInfo adminInfo){
        AdminInfo adminInfo1 = adminService.queryAdminInfo(adminInfo);
        return adminInfo1;
    }

    @RequestMapping(value = "/queryRoleInof",method = RequestMethod.GET)
    @ResponseBody
    public List<RoleInfo> queryRoleInof(){
        List<RoleInfo> roleInfoList = adminService.queryRoleInof();
        return roleInfoList;
    }

    @RequestMapping(value = "/updateAdminData",method = RequestMethod.POST)
    public String updateAdminData(@RequestBody AdminRoleParams params){
        adminService.updateAdminData(params);
        return "admin/admin_list";
    }

}
