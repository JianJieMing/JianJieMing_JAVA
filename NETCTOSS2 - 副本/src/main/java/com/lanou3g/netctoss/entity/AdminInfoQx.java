package com.lanou3g.netctoss.entity;

import org.springframework.stereotype.Component;

/**
 * @author 铭
 * 2018/10/10 8:16
 */
@Component
public class AdminInfoQx extends AdminInfo{

    private String qx;



    @Override
    public String toString() {
        return "AdminInfoQx{" +
                "qx='" + qx + '\'' +
                '}';
    }

    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }
}
