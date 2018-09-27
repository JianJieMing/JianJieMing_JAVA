package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoodsCategory;
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

public class CategoryMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private CategoryMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        mapper = sqlSession.getMapper(CategoryMapper.class);
        // 简单查询所有类别
        List<TbGoodsCategory> allSimple = mapper.findAllSimple();
        allSimple.forEach(System.out::println);
        System.out.println("******************");
        // 查询所有类别携带商品信息
        List<TbGoodsCategory> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

}