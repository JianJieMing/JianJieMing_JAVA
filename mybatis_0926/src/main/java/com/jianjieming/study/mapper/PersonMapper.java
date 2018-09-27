package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.Person;
import com.jianjieming.study.entity.Student;

import java.util.List;
import java.util.Map;

public interface PersonMapper {

    List<Person> findAll();

    Person findOne(Map map);

    Person findIdAndName(Person person);

    void insertPerson(Person person);

    void updatePerson(Person person);

//    int updateOne(String name);

    void deletePerson(int id);

    List<Student> showAll();

    int updateOne(Person p);

    int addOne (Person person);

}
