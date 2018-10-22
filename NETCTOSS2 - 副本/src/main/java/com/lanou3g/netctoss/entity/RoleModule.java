package com.lanou3g.netctoss.entity;

import java.util.List;

public class RoleModule {

  private Integer roleId;
  private Integer moduleId;

  private List<ModuleInfo> moduleInfoList;

    @Override
    public String toString() {
        return "RoleModule{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                ", moduleInfoList=" + moduleInfoList +
                '}';
    }

    public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public Integer getModuleId() {
    return moduleId;
  }

  public void setModuleId(Integer moduleId) {
    this.moduleId = moduleId;
  }

}
