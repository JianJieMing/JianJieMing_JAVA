package com.lanou3g.netctoss.role.controller.params;

import java.util.List;

/**
 * @author 铭
 * 2018/10/10 14:20
 */
public class RoleParams {

    private String roleName;
    private List<Integer> moduleIds;

    @Override
    public String toString() {
        return "RoleParams{" +
                "roleName='" + roleName + '\'' +
                ", moduleIds=" + moduleIds +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }
}
