package com.lanou3g.netctoss.admin.service;

import com.lanou3g.netctoss.admin.controller.params.AdminParams;
import com.lanou3g.netctoss.admin.controller.params.AdminRoleParams;
import com.lanou3g.netctoss.admin.mapper.AdminMapper;
import com.lanou3g.netctoss.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * 2018/10/10 8:26
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<AdminInfoQx> queryAdminAndRole(ModuleInfo moduleInfo) {
        List<AdminInfoQx> adminInfoQxes = adminMapper.queryAdminAndRole(moduleInfo);
        return adminInfoQxes;
    }

    @Override
    public List<ModuleInfo> queryModuleName() {
        List<ModuleInfo> moduleInfos = adminMapper.queryModuleName();
        return moduleInfos;
    }

    @Override
    public List<AdminInfoQx> queryRoleName(RoleInfo roleInfo) {
        List<AdminInfoQx> adminInfoQxes = adminMapper.queryRoleName(roleInfo);
        return adminInfoQxes;
    }

    @Transactional
    @Override
    public void updatePassword(AdminParams adminParams) {
        List<Integer> adminIds = adminParams.getAdminIds();
        adminMapper.updatePassword(adminIds);
    }

    @Transactional
    @Override
    public void insertAdminAndAdminRole(AdminRoleParams adminRoleParams) {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setPassword(adminRoleParams.getPassword());
        adminInfo.setAdminCode(adminRoleParams.getAdminCode());
        adminInfo.setName(adminRoleParams.getName());
        adminInfo.setTelephone(adminRoleParams.getTelephone());
        adminInfo.setEmail(adminRoleParams.getEmail());
        adminInfo.setEnrolldate(adminRoleParams.getEnrolldate());

        Integer messages = adminMapper.insertAdminUserMessages(adminInfo);
        System.out.println(adminInfo.getAdminId() + "?????");
        if (messages != null) {
            List<AdminRole> adminRoles = new ArrayList<>();
            List<Integer> roleId = adminRoleParams.getRoleIds();
            util(adminRoles, roleId, adminInfo.getAdminId(), adminRoleParams);
            adminMapper.insertAdminRole(adminRoles);
        }
    }

    @Override
    public List<RoleInfo> queryRoleInfoName() {
        List<RoleInfo> roleInfos = adminMapper.queryRoleInfoName();
        return roleInfos;
    }

    @Transactional
    @Override
    public void deleteAdminInfoAndAnminRole(AdminInfo adminInfo) {
        adminMapper.deleteAdminInfo(adminInfo);
        adminMapper.deleteAdminAndRole(adminInfo);
    }

    @Override
    public AdminInfo queryAdminInfo(AdminInfo adminInfo) {
        AdminInfo adminInfo1 = adminMapper.queryAdminInfo(adminInfo);
        return adminInfo1;
    }

    @Override
    public List<RoleInfo> queryRoleInof() {
        List<RoleInfo> roleInfoList = adminMapper.queryRoleInof();
        return roleInfoList;
    }

    @Transactional
    @Override
    public void updateAdminData(AdminRoleParams adminRoleParams) {
        // 更新管理员信息
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminId(adminRoleParams.getAdminId());
        adminInfo.setName(adminRoleParams.getName());
        adminInfo.setTelephone(adminRoleParams.getTelephone());
        adminInfo.setEmail(adminRoleParams.getEmail());
        System.out.println(adminInfo.getAdminId());
        adminMapper.updateAdminData(adminInfo);
        // 删除管理员以前的角色
        adminMapper.deleteAdminRole(adminInfo);
        // 添加管理员的新角色
        List<AdminRole> adminRoles = new ArrayList<>();
        List<Integer> roleIds = adminRoleParams.getRoleIds();
        util(adminRoles, roleIds, adminRoleParams.getAdminId(), adminRoleParams);
        adminMapper.insertAdminRoles(adminRoles);
    }

    private void util(List<AdminRole> adminRoles, List<Integer> roleIds, Integer adminId, AdminRoleParams adminRoleParams) {
        for (int i = 0; i < roleIds.size(); i++) {
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(adminId);
            adminRole.setRoleId(roleIds.get(i));
            adminRoles.add(adminRole);
        }
    }


}
