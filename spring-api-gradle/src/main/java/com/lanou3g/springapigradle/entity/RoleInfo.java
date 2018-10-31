package com.lanou3g.springapigradle.entity;

import javax.persistence.*;

/**
 * @author 铭
 * 2018/10/31 10:18
 */
@Entity
@Table(name = "role_info")
public class RoleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String name;

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
