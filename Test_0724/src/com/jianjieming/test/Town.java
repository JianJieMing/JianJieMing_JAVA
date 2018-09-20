package com.jianjieming.test;

import com.google.gson.annotations.SerializedName;

/**
 * @author 铭
 */
public class Town {
    @SerializedName("市")
    private String townName;
    private int coding;

    public int getCoding() {
        return coding;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
