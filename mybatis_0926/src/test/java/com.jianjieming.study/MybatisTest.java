package com.jianjieming.study;

import com.jianjieming.study.mapper.PersonMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 铭
 * 2018/9/26 10:53
 */
public class MybatisTest {

    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        // 获取SqlSessionFactory对象
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        // 执行在Mapper文件中定义的statement
//        List<Person> list = sqlSession.selectList("person.findAll");
//        for (Person person : list) {
//            System.out.println(person);
//        }
        List<Person> all = mapper.findAll();
        all.forEach(System.out::println);
        System.out.println("**************");
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        Person one = mapper.findOne(map);
        System.out.println(one);
        System.out.println("***************");
        Person person = new Person();
        person.setId(5);
        Person idAndName = mapper.findIdAndName(person);
        System.out.println(idAndName);
        System.out.println("***************");
        Person person1 = new Person();
        person1.setName("孙风");
        person1.setAge(26);
        mapper.insertPerson(person1);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}
