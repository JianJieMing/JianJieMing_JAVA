package com.lanou3g.springbootdemo.entity;


import com.lanou3g.springbootdemo.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "admin_info")
public class AdminInfo extends BaseEntity implements Serializable {

  @Id
  private Long adminId;
  private String adminCode;
  private String password;
  private String name;
  private String telephone;
  private String email;
  private java.sql.Timestamp enrolldate;


  public Long getAdminId() {
    return adminId;
  }

  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }


  public String getAdminCode() {
    return adminCode;
  }

  public void setAdminCode(String adminCode) {
    this.adminCode = adminCode;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public java.sql.Timestamp getEnrolldate() {
    return enrolldate;
  }

  public void setEnrolldate(java.sql.Timestamp enrolldate) {
    this.enrolldate = enrolldate;
  }

}
