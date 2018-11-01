package com.lanou3g.springjpademo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * 2018/10/31 16:41
 */
@Entity
@Table(name = "role_info")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    // 生成之后的role_name表中的列名,唯一,不为空,varchar(50)
    @Column(name = "role_name", unique = true, nullable = false, length = 50)
    private String roleName;

    private Integer deleteFlag;

    @Setter
    @Getter
    @ManyToMany // 多对多关系
    @JoinTable(
            // 中间表的表名.
            name = "role_module",
            // 对应中间表的一个列名,和当前表的主键roleId关联的.
            joinColumns = @JoinColumn(name = "temp_role_id"),
            // 中间表的另一个列名,和另一张表的主键相关联.
            inverseJoinColumns = @JoinColumn(name = "temp_module_id")
    )

//    @JsonManagedReference
    private List<ModuleEntity> moduleEntityList = new ArrayList<>();

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
