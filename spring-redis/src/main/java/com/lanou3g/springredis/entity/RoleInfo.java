package com.lanou3g.springredis.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_info")
public class RoleInfo implements Serializable {

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
