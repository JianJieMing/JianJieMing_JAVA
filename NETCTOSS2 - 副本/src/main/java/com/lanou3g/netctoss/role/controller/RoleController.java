package com.lanou3g.netctoss.role.controller;

import com.lanou3g.netctoss.entity.ModuleInfo;
import com.lanou3g.netctoss.entity.RoleInfo;
import com.lanou3g.netctoss.entity.RoleInfoQx;
import com.lanou3g.netctoss.role.controller.params.RoleModuleParams;
import com.lanou3g.netctoss.role.controller.params.RoleParams;
import com.lanou3g.netctoss.role.service.RoleService;
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
 * 2018/10/9 11:11
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "role_list")
    public String queryUserAndPermissions(Model model) {
        List<RoleInfoQx> adminInfos = roleService.queryUserAndPermissions();
        model.addAttribute("adminInfos", adminInfos);
        return "/role/role_list";
    }

    @RequestMapping(value = "insertRole", method = RequestMethod.POST)
    public String insertRoleAndModule(Model model, @RequestBody RoleParams params) {
        boolean b = roleService.insertRoleWithModule(params);
        if (b) {
            model.addAttribute("message", true);
        } else {
            model.addAttribute("message", false);
        }
        return "/role/role_add";
    }

    @RequestMapping(value = "role_add")
    public String queryModuleName(Model model) {
        List<ModuleInfo> moduleInfos = roleService.queryModuleName();
        model.addAttribute("moduleInfos", moduleInfos);
        return "/role/role_add";
    }

    @RequestMapping(value = "/updateRoleData", method = RequestMethod.POST)
    public String updateAdminData(@RequestBody RoleModuleParams params) {
        List<Integer> moduleIds = params.getModuleIds();
        moduleIds.forEach(System.out::println);
        roleService.updateRoleData(params);
        return "role/role_list";
    }

    @RequestMapping(value = "/queryModule", method = RequestMethod.GET)
    @ResponseBody
    public List<ModuleInfo> queryModule() {
        List<ModuleInfo> moduleInfos = roleService.queryModule();
        return moduleInfos;
    }

    @RequestMapping(value = "/deleteRoleAndRoleModule", method = RequestMethod.POST)
    public String deleteRoleAndRoleModule(@RequestBody RoleInfo roleInfo) {
        Integer roleId = roleInfo.getRoleId();
        System.out.println(roleId+"****************");
        roleService.deleteRoleAndRoleModule(roleInfo);
        return "role/role_list";
    }

}
