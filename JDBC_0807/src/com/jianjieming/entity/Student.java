package com.jianjieming.entity;

import java.sql.Date;

/**
 * @author 铭
 */
public class Student {

    private int stuId;
    private String stuName;
    private Date birthday;
    private String stuGender;

    public Student() {
    }

    public Student(int stuId, String stuName, Date birthday, String stuGender) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.birthday = birthday;
        this.stuGender = stuGender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", birthday=" + birthday +
                ", stuGender='" + stuGender + '\'' +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
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
