package com.lanou3g.netctoss.entity;

public class AdminInfo {

  private Integer adminId;
  private String adminCode;
  private String password;
  private String name;
  private String telephone;
  private String email;
  private java.sql.Timestamp enrolldate;

  private AdminRole adminRole;

  @Override
  public String toString() {
    return "AdminInfo{" +
            "adminId=" + adminId +
            ", adminCode='" + adminCode + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", telephone='" + telephone + '\'' +
            ", email='" + email + '\'' +
            ", enrolldate=" + enrolldate +
            ", adminRole=" + adminRole +
            '}';
  }

  public AdminRole getAdminRole() {
    return adminRole;
  }

  public void setAdminRole(AdminRole adminRole) {
    this.adminRole = adminRole;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
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
