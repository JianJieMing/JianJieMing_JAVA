package com.lanou3g.springbootdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_info")
public class RoleInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roleId;
  private String name;

  @Override
  public String toString() {
    return "RoleInfo{" +
            "roleId=" + roleId +
            ", name='" + name + '\'' +
            '}';
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
