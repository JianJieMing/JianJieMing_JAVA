package com.lanou3g.netctoss.entity;

import java.util.List;

public class AdminRole {

  private Integer adminId;
  private Integer roleId;

  private List<RoleInfo> roleInfoList;

  @Override
  public String toString() {
    return "AdminRole{" +
            "adminId=" + adminId +
            ", roleId=" + roleId +
            ", roleInfoList=" + roleInfoList +
            '}';
  }

  public List<RoleInfo> getRoleInfoList() {
    return roleInfoList;
  }

  public void setRoleInfoList(List<RoleInfo> roleInfoList) {
    this.roleInfoList = roleInfoList;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

}
