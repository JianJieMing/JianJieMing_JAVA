package com.lanou3g.netctoss.information.controller.params;


import com.lanou3g.netctoss.entity.AdminInfo;

public class AdminInfoImpl extends AdminInfo {
    private String rNames;

    @Override
    public String toString() {
        return "AdminInfoImpl{" +
                "rNames='" + rNames + '\'' +
                "} " + super.toString();
    }

    public String getrNames() {
        return rNames;
    }

    public void setrNames(String rNames) {
        this.rNames = rNames;
    }
}
