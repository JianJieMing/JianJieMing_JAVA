package com.jianjieming.test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 铭
 */
public class Province {
    @SerializedName("省")
    private String ProvinceName;
    private List<Town> townList;

    public List<Town> getTownList() {
        return townList;
    }

    public void setTownList(List<Town> townList) {
        this.townList = townList;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }
}
