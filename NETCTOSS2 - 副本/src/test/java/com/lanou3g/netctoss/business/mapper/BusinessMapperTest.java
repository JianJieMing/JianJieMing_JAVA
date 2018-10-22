package com.lanou3g.netctoss.business.mapper;

import com.lanou3g.netctoss.business.service.BusinessService;
import com.lanou3g.netctoss.entity.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml","classpath:mybatis-config.xml"})
public class BusinessMapperTest {

    @Resource
    private BusinessService service;

    @Test
    public void test(){
        List<Service> tservices = service.queryBusiness();
        tservices.forEach(System.out::println);
    }

}