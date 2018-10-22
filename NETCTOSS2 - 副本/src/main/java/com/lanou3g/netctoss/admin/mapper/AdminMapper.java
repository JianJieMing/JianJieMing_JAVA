package com.lanou3g.netctoss.admin.mapper;

import com.lanou3g.netctoss.admin.controller.params.AdminParams;
import com.lanou3g.netctoss.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    List<AdminInfoQx> queryAdminAndRole(ModuleInfo moduleInfo);

    List<ModuleInfo> queryModuleName();

    List<AdminInfoQx> queryRoleName(RoleInfo roleInfo);

    void updatePassword (List<Integer> adminIds);

    Integer insertAdminUserMessages(AdminInfo adminInfo);

    void insertAdminRole(List<AdminRole> adminRoles);

    List<RoleInfo> queryRoleInfoName();

    void deleteAdminInfo(AdminInfo adminInfo);

    void deleteAdminAndRole(AdminInfo adminInfo);

    AdminInfo queryAdminInfo(AdminInfo adminInfo);

    List<RoleInfo> queryRoleInof();

    void updateAdminData(AdminInfo adminInfo);

    void deleteAdminRole(AdminInfo adminInfo);

    void insertAdminRoles(List<AdminRole> roleInfoList);

}
