package com.jianjieming.Test02;

import com.jianjieming.Test01.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 铭
 * DATE: 18/9/12 上午9:46
 */
@Component
public class Dog {

    @Value("tom")
    private String name;
    @Value("3")
    private Integer age;

    @Resource(name = "person")
//    @Autowired
    private Person host;

    private List<String> list;
    private List<Person> personList;
    private Set<String> set;
    private Set<Person> personSet;
    private Map<String, String> map;
    private Map<String, Person> personMap;
    private Properties properties;

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
}
