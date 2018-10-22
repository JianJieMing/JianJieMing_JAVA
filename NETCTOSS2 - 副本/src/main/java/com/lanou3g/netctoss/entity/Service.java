package com.lanou3g.netctoss.entity;


public class Service {

  private Integer serviceId;
  private Integer accountId;
  private String unixHost;
  private String osUsername;
  private String loginPasswd;
  private String status;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp pauseDate;
  private java.sql.Timestamp closeDate;
  private Integer costId;

  private Account account;
  private Cost cost;

  @Override
  public String toString() {
    return "Service{" +
            "serviceId=" + serviceId +
            ", accountId=" + accountId +
            ", unixHost='" + unixHost + '\'' +
            ", osUsername='" + osUsername + '\'' +
            ", loginPasswd='" + loginPasswd + '\'' +
            ", status='" + status + '\'' +
            ", createDate=" + createDate +
            ", pauseDate=" + pauseDate +
            ", closeDate=" + closeDate +
            ", costId=" + costId +
            ", account=" + account +
            ", cost=" + cost +
            '}';
  }

  public Cost getCost() {
    return cost;
  }

  public void setCost(Cost cost) {
    this.cost = cost;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Integer getServiceId() {
    return serviceId;
  }

  public void setServiceId(Integer serviceId) {
    this.serviceId = serviceId;
  }


  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }


  public String getUnixHost() {
    return unixHost;
  }

  public void setUnixHost(String unixHost) {
    this.unixHost = unixHost;
  }


  public String getOsUsername() {
    return osUsername;
  }

  public void setOsUsername(String osUsername) {
    this.osUsername = osUsername;
  }


  public String getLoginPasswd() {
    return loginPasswd;
  }

  public void setLoginPasswd(String loginPasswd) {
    this.loginPasswd = loginPasswd;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public java.sql.Timestamp getPauseDate() {
    return pauseDate;
  }

  public void setPauseDate(java.sql.Timestamp pauseDate) {
    this.pauseDate = pauseDate;
  }


  public java.sql.Timestamp getCloseDate() {
    return closeDate;
  }

  public void setCloseDate(java.sql.Timestamp closeDate) {
    this.closeDate = closeDate;
  }

  public Integer getCostId() {
    return costId;
  }

  public void setCostId(Integer costId) {
    this.costId = costId;
  }
}