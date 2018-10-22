package com.lanou3g.netctoss.mapper;

import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.service.CostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class CostMapperTest {

    @Autowired
    private CostService costService;

    @Test
    public void test(){
        Cost cost = new Cost();
        cost.setName("3333");
        cost.setBaseCost(333L);
        costService.insertOne(cost);
    }
}