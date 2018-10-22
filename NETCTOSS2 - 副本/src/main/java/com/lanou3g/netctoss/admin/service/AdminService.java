package com.lanou3g.netctoss.admin.service;

import com.lanou3g.netctoss.admin.controller.params.AdminParams;
import com.lanou3g.netctoss.admin.controller.params.AdminRoleParams;
import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.entity.AdminInfoQx;
import com.lanou3g.netctoss.entity.ModuleInfo;
import com.lanou3g.netctoss.entity.RoleInfo;

import java.util.List;

/**
 * @author 铭
 * 2018/10/10 8:24
 */
public interface AdminService {

    List<AdminInfoQx> queryAdminAndRole(ModuleInfo moduleInfo);

    List<ModuleInfo> queryModuleName();

    List<AdminInfoQx> queryRoleName(RoleInfo roleInfo);

    void updatePassword (AdminParams adminParams);

    void insertAdminAndAdminRole(AdminRoleParams adminRoleParams);

    List<RoleInfo> queryRoleInfoName();

    void deleteAdminInfoAndAnminRole(AdminInfo adminInfo);

    AdminInfo queryAdminInfo(AdminInfo adminInfo);

    List<RoleInfo> queryRoleInof();

    void updateAdminData(AdminRoleParams adminRoleParams);

}
