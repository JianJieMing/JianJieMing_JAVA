package com.lanou3g.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 铭
 * 2018/11/5 19:30
 */
@Entity
@Table(name = "admin_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(name = "admin_name", nullable = false, length = 25, unique = true)
    private String adminName;

    @Column(name = "username", nullable = false, length = 25, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 25, unique = true)
    private String password;

    @Column(name = "age", nullable = false, length = 25, unique = true)
    private String age;

    @Column(name = "hobby", nullable = false, length = 25, unique = true)
    private String hobby;

}

