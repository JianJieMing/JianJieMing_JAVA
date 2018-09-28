package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.OrderMoney;
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


public class OrderMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private OrderMapper mapper;


    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        mapper = sqlSession.getMapper(OrderMapper.class);
        List<TbOrder> tbOrders = mapper.queryOrderAndGoods();
        tbOrders.forEach(System.out::println);
        System.out.println("**************");
        TbOrder tbOrder = new TbOrder();
        tbOrder.setOrderId(2);
        List<TbOrder> tbOrders1 = mapper.queryOrderAndOrderitemAndGoods(tbOrder);
        tbOrders1.forEach(System.out::println);
        System.out.println("****************");
        List<OrderMoney> monies = mapper.queryOrderMoney();
        monies.forEach(System.out::println);
        System.out.println("***************");
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}