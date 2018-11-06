package com.lanou3g.tokendemo111.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 创建人: 铭
 * 创建事件: 2018/11/2
 */
@Entity
@Data
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",
            joinColumns={@JoinColumn(name="roleId")},
            inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name="SysUserRole",
            joinColumns={@JoinColumn(name="roleId")},
            inverseJoinColumns={@JoinColumn(name="userId")})
    private List<UserInfo> userInfos;// 一个角色对应多个用户

    // 省略 get set 方法
}
