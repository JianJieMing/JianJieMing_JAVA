package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbGoods;
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

public class GoodsMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private GoodsMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        mapper = sqlSession.getMapper(GoodsMapper.class);
        List<TbGoods> allWithCategory = mapper.findAllWithCategory();
        allWithCategory.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

}