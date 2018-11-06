package com.lanou3g.springjpademo.entity;

import lombok.*;
import javax.persistence.*;

/**
 * @author 铭
 * 2018/10/31 16:54
 */
@Entity
@Table(name = "module_info")
// data 包含set/get/toString/equals
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @Column(name = "module_name", unique = true, nullable = false, length = 50)
    private String moduleName;

//    @JsonBackReference
//    private List<RoleEntity> roleEntityList;

}
