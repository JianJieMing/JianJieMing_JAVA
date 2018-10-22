package com.lanou3g.netctoss.role.service;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.entity.ModuleInfo;
import com.lanou3g.netctoss.entity.RoleInfo;
import com.lanou3g.netctoss.entity.RoleInfoQx;
import com.lanou3g.netctoss.role.controller.params.RoleModuleParams;
import com.lanou3g.netctoss.role.controller.params.RoleParams;

import java.util.List;

public interface RoleService {

    List<RoleInfoQx> queryUserAndPermissions();

    List<ModuleInfo> queryModuleName();

    boolean insertRoleWithModule(RoleParams params);

    void updateRoleData(RoleModuleParams roleModuleParams);

    List<ModuleInfo> queryModule();

    void deleteRoleAndRoleModule(RoleInfo roleInfo);

}
