package com.lanou3g.netctoss.role.controller.params;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 铭
 * 2018/10/12 10:41
 */
public class RoleModuleParams {
    private Integer roleId;
    private List<Integer> moduleIds;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }
}
