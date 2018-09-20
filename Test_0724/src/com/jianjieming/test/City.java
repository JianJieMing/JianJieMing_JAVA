package com.jianjieming.test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 铭
 */
public class City {
    @SerializedName("城市代码")
    private String CityName;
    private List<Province> provinceList;
    private List<Town> townList;

    @Override
    public String toString() {
        return "City{" +
                "CityName='" + CityName + '\'' +
                ", provinceList=" + provinceList +
                ", townList=" + townList +
                '}';
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public List<Town> getTownList() {
        return townList;
    }

    public void setTownList(List<Town> townList) {
        this.townList = townList;
    }
}
