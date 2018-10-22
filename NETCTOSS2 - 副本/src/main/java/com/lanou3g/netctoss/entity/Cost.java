package com.lanou3g.netctoss.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Cost {

  private Long costId;
  private String name;
  private Integer baseDuration;
  private Integer baseCost;
  private Integer unitCost;
  private String status;
  private String descr;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Timestamp creatime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Timestamp startime;
  private String costType;

  @Override
  public String toString() {
    return "Cost{" +
            "costId=" + costId +
            ", name='" + name + '\'' +
            ", baseDuration=" + baseDuration +
            ", baseCost=" + baseCost +
            ", unitCost=" + unitCost +
            ", status='" + status + '\'' +
            ", descr='" + descr + '\'' +
            ", creatime=" + creatime +
            ", startime=" + startime +
            ", costType='" + costType + '\'' +
            '}';
  }

  public Long getCostId() {
    return costId;
  }

  public void setCostId(Long costId) {
    this.costId = costId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getBaseDuration() {
    return baseDuration;
  }

  public void setBaseDuration(Integer baseDuration) {
    this.baseDuration = baseDuration;
  }


  public Integer getBaseCost() {
    return baseCost;
  }

  public void setBaseCost(Integer baseCost) {
    this.baseCost = baseCost;
  }


  public Integer getUnitCost() {
    return unitCost;
  }

  public void setUnitCost(Integer unitCost) {
    this.unitCost = unitCost;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }


  public java.sql.Timestamp getCreatime() {
    return creatime;
  }

  public void setCreatime(java.sql.Timestamp creatime) {
    this.creatime = creatime;
  }


  public java.sql.Timestamp getStartime() {
    return startime;
  }

  public void setStartime(java.sql.Timestamp startime) {
    this.startime = startime;
  }


  public String getCostType() {
    return costType;
  }

  public void setCostType(String costType) {
    this.costType = costType;
  }

}
