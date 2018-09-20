package com.jianjieming.Test02;

import java.util.List;
import java.util.Map;

/**
 * @author 铭
 * DATE: 18/9/12 上午10:47
 */
public class ClassRoom {
    private String name;
    private Integer num;
    private List<Person> personList;
    private Map<String,Person> personMap;

    public ClassRoom() {
    }

    public ClassRoom(String name, Integer num, List<Person> personList, Map<String, Person> personMap) {
        this.name = name;
        this.num = num;
        this.personList = personList;
        this.personMap = personMap;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", personList=" + personList +
                ", personMap=" + personMap +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }
}
