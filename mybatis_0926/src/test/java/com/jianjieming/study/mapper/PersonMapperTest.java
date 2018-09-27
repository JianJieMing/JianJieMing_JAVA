package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.Person;
import com.jianjieming.study.entity.Sc;
import com.jianjieming.study.entity.Student;
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
//        int updateOne = mapper.updateOne("张三");
//        mapper.deletePerson(10);
//        List<Student> showAll = mapper.showAll();
//        showAll.forEach(System.out::println);

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("新人");
        person1.setAge(38);
        mapper.updateOne(person1);

        Person p = new Person();
        p.setName("国子见");
        p.setAge(86);
        mapper.addOne(p);
        System.out.println(p);



    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}