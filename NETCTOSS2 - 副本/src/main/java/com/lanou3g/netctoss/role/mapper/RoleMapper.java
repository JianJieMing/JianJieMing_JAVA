package com.lanou3g.netctoss.role.mapper;

import com.lanou3g.netctoss.entity.*;

import java.util.List;

/**
 * @author 铭
 * 2018/10/9 10:31
 */
public interface RoleMapper {

    List<RoleInfoQx> queryUserAndPermissions();

    List<ModuleInfo> queryModuleName();

    int addRoleInfo(RoleInfo roleInfo);

    int addRoleModule(List<RoleModule> roleModules);

    void updateRoleData(RoleInfo roleInfo);

    void deleteRoleModule(RoleInfo roleInfo);

    void insertRoleModule(List<RoleModule> roleModules);

    List<ModuleInfo> queryModule();

    void deleteRoleInfo(RoleInfo roleInfo);

}
