package com.lanou3g.springbootdemo.entity;


public class ModuleInfo {

  private Long moduleId;
  private String name;

  @Override
  public String toString() {
    return "ModuleInfo{" +
            "moduleId=" + moduleId +
            ", name='" + name + '\'' +
            '}';
  }

  public Long getModuleId() {
    return moduleId;
  }

  public void setModuleId(Long moduleId) {
    this.moduleId = moduleId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
