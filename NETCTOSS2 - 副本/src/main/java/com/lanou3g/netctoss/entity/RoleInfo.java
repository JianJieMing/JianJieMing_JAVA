package com.lanou3g.netctoss.entity;

public class RoleInfo {

  private Integer roleId;
  private String name;

  private RoleModule roleModule;

  @Override
  public String toString() {
    return "RoleInfo{" +
            "roleId=" + roleId +
            ", name='" + name + '\'' +
            ", roleModule=" + roleModule +
            '}';
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
