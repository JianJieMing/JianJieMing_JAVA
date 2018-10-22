package com.lanou3g.netctoss.entity;

public class ModuleInfo {

  private Integer moduleId;
  private String name;

  @Override
  public String toString() {
    return "ModuleInfo{" +
            "moduleId=" + moduleId +
            ", name='" + name + '\'' +
            '}';
  }

  public Integer getModuleId() {
    return moduleId;
  }

  public void setModuleId(Integer moduleId) {
    this.moduleId = moduleId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
