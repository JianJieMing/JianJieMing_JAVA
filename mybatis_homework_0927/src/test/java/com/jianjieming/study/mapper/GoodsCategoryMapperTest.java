package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.OrderMoney;
import com.jianjieming.study.entity.TbGoods;
import com.jianjieming.study.entity.TbGoodsCategory;
import com.jianjieming.study.entity.TbOrder;
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

public class GoodsCategoryMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private GoodsCategoryMapper goodsCategoryMapper;


    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<TbGoods> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void test2() {
        goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);
        TbGoodsCategory byId = goodsCategoryMapper.findById(3);
        System.out.println(byId);
    }

    @Test
    public void test3() {
        goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);
        List<TbGoodsCategory> allWithGoods = goodsCategoryMapper.findAllWithGoods();
        allWithGoods.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

}