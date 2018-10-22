package com.lanou3g.netctoss.information.mapper;

import com.lanou3g.netctoss.entity.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml","classpath:mybatis-config.xml"})
public class InformationMapperTest {

    @Resource
    private InformationMapper informationMapper;

    @Test
    public void modify() {
    }

    @Test
    public void selectAll() {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminCode("admin");
        AdminInfo adminInfo1 = informationMapper.selectAll(adminInfo);
        System.out.println(adminInfo1);
    }
}