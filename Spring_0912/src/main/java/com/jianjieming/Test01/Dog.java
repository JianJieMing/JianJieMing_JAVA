package com.jianjieming.Test01;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 铭
 * DATE: 18/9/12 上午9:46
 */
public class Dog {

    private String name;
    private Integer age;
    private Person host;
    private List<String> list;
    private List<Person> personList;
    private Set<String> set;
    private Set<Person> personSet;
    private Map<String,String> map;
    private Map<String,Person> personMap;
    private Properties properties;

    public Dog() {
    }

    public Dog(String name, Integer age, Person host) {
        this.name = name;
        this.age = age;
        this.host = host;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", host=" + host +
                ", list=" + list +
                ", personList=" + personList +
                ", set=" + set +
                ", personSet=" + personSet +
                ", map=" + map +
                ", personMap=" + personMap +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
