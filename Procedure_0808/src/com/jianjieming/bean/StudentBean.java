package com.jianjieming.bean;

import java.sql.Date;
import java.util.List;

/**
 * @author 铭
 */
public class StudentBean {

    private int stuID;
    private String stuName;
    private Date birthday;
    private String stuGender;
    private List<ScoreBean> scoreBeanList;

    @Override
    public String toString() {
        return "StudentBean{" +
                "stuID=" + stuID +
                ", stuName='" + stuName + '\'' +
                ", birthday=" + birthday +
                ", stuGender='" + stuGender + '\'' +
                ", scoreBeanList=" + scoreBeanList +
                '}' + "\n";
    }

    public List<ScoreBean> getScoreBeanList() {
        return scoreBeanList;
    }

    public void setScoreBeanList(List<ScoreBean> scoreBeanList) {
        this.scoreBeanList = scoreBeanList;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }
}
