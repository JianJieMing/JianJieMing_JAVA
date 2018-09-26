package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class PersonMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 获取SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        System.out.println(mapper.getClass()+"****");
        List<Person> all = mapper.findAll();
        all.forEach(System.out::println);
        System.out.println("************************");
        Person person = new Person();
        person.setId(3);
        person.setName("王五");
        person.setAge(17);
        Person idAndName = mapper.findIdAndName(person);
        System.out.println(idAndName);
        System.out.println("************************");
//        Person person1 = new Person();
//        person.setId(3);
//        person.setName("卡特琳娜");
//        person.setAge(66);
//        mapper.updatePerson(person1);
        int updateOne = mapper.updateOne("张三");

    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}