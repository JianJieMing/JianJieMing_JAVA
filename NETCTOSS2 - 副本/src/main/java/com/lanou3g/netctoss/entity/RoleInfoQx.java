package com.lanou3g.netctoss.entity;

/**
 * @author 铭
 * 2018/10/9 16:05
 */
public class RoleInfoQx extends RoleInfo {

    private String qx;

    @Override
    public String toString() {
        return "RoleInfoQx{" +
                "qx='" + qx + '\'' +
                "} " + super.toString();
    }

    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }
}
