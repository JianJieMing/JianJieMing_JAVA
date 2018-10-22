package com.lanou3g.netctoss.role.service;

import com.lanou3g.netctoss.entity.*;
import com.lanou3g.netctoss.role.controller.params.RoleModuleParams;
import com.lanou3g.netctoss.role.controller.params.RoleParams;
import com.lanou3g.netctoss.role.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * 2018/10/9 11:05
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleInfoQx> queryUserAndPermissions() {
        List<RoleInfoQx> adminInfos = roleMapper.queryUserAndPermissions();
        return adminInfos;
    }

    @Override
    public List<ModuleInfo> queryModuleName() {
        List<ModuleInfo> moduleInfos = roleMapper.queryModuleName();
        return moduleInfos;
    }

    @Transactional
    @Override
    public boolean insertRoleWithModule(RoleParams params) {
        try {
            RoleInfo role = new RoleInfo();
            role.setName(params.getRoleName());
            roleMapper.addRoleInfo(role);
            List<RoleModule> roleModules = new ArrayList<>();
            for (int i = 0; i < params.getModuleIds().size(); i++) {
                RoleModule module = new RoleModule();
                module.setRoleId(role.getRoleId());
                module.setModuleId(params.getModuleIds().get(i));
                roleModules.add(module);
            }
            roleMapper.addRoleModule(roleModules);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    @Override
    public void updateRoleData(RoleModuleParams roleModuleParams) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleModuleParams.getRoleId());
        roleInfo.setName(roleModuleParams.getName());
        roleMapper.updateRoleData(roleInfo);
        roleMapper.deleteRoleModule(roleInfo);
        List<RoleModule> roleModuleList = new ArrayList<>();
        List<Integer> moduleIds = roleModuleParams.getModuleIds();
        for (int i = 0; i < moduleIds.size(); i++) {
            RoleModule roleModule = new RoleModule();
            roleModule.setRoleId(roleModuleParams.getRoleId());
            roleModule.setModuleId(moduleIds.get(i));
            roleModuleList.add(roleModule);
        }
        roleMapper.insertRoleModule(roleModuleList);
    }

    @Override
    public List<ModuleInfo> queryModule() {
        List<ModuleInfo> moduleInfos = roleMapper.queryModule();
        return moduleInfos;
    }

    @Transactional
    @Override
    public void deleteRoleAndRoleModule(RoleInfo roleInfo) {
        roleMapper.deleteRoleInfo(roleInfo);
        roleMapper.deleteRoleModule(roleInfo);
    }
}
