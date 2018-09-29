package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.OrderMoney;
import com.jianjieming.study.entity.TbOrder;
import com.jianjieming.study.entity.TbUser;
import com.jianjieming.study.entity.UserMoney;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 铭
 * 2018/9/27 23:20
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        mapper = sqlSession.getMapper(UserMapper.class);
        List<UserMoney> userMonies = mapper.userMoney();
        userMonies.forEach(System.out::println);
    }

    @Test
    public void test2() {
        mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> objectMap = new HashMap<>();
//        objectMap.put("userName","%小%");
        objectMap.put("gender","女");
//        objectMap.put("maxHeight", 1.8);
        System.out.println("第一次查询");
        List<TbUser> condition = this.mapper.findAllCondition(objectMap);
        condition.forEach(System.out::println);
        System.out.println("第二次查询");
        List<TbUser> condition2 = this.mapper.findAllCondition(objectMap);
        condition2.forEach(System.out::println);
    }

    @Test
    public void test3() {
        mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> objectMap = new HashMap<>();
//        objectMap.put("userName","%小%");
        objectMap.put("gender","女");
//        objectMap.put("minHeight", 1.8);
        System.out.println("第一次查询");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        List<TbUser> all = mapper1.findAll(objectMap);
        all.forEach(System.out::println);
        sqlSession.close();

        System.out.println("第二次查询");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        List<TbUser> all2 = mapper2.findAll(objectMap);
        all2.forEach(System.out::println);
        sqlSession2.close();

        System.out.println("第三次查询");
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        List<TbUser> all3 = mapper3.findAll(objectMap);
        all3.forEach(System.out::println);
        sqlSession3.close();
    }

    @Test
    public void test4() {
        mapper = sqlSession.getMapper(UserMapper.class);
        TbUser user = new TbUser();
        user.setUserId(6L);
        user.setHeight(1.90F);
        user.setWeight(78.00F);
        user.setUserName("必胜碰");
        int i = mapper.updateOne(user);
    }

    @Test
    public void test5() {
        mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(6);
        int i = mapper.deleteByUserIds(ids);
        System.out.println(i);
    }

    @Test
    public void test6() {
        mapper = sqlSession.getMapper(UserMapper.class);
        List<TbUser> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TbUser user = new TbUser();
            user.setUserName("影分身");
            user.setGender("男");
            user.setHeight(2.1F);
            user.setWeight(20F + i);
            user.setBirthday(Date.valueOf("1999-01-01"));
            user.setDeleteFlag(0);
            users.add(user);
        }
        int i = mapper.addUsers(users);
    }

    @Test
    public void test7() {
        mapper = sqlSession.getMapper(UserMapper.class);
        List<TbUser> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TbUser user = new TbUser();
            user.setUserId(57L + i);
            user.setUserName("影分身");
            user.setGender("男");
            user.setHeight(2.1F);
            user.setWeight(20F + i);
            users.add(user);
        }
        int i = mapper.updateUsers(users);
        System.out.println("更新了: " + i + "条数据");
    }


    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

}