package com.lanou3g.netctoss.cost.mapper;

import com.lanou3g.netctoss.entity.Cost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml","classpath:mybatis-config.xml"})
public class CostMapperTest {

    @Resource
    private CostMapper costMapper;

    @Test
    public void test(){
        Cost cost = new Cost();
        cost.setCostId(1l);
        cost.setName("全家桶");
        costMapper.updateAll(cost);
    }

}