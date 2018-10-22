package com.lanou3g.netctoss.admin.mapper;

import com.lanou3g.netctoss.admin.service.AdminService;
import com.lanou3g.netctoss.entity.AdminInfoQx;
import com.lanou3g.netctoss.entity.ModuleInfo;
import com.lanou3g.netctoss.entity.RoleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml", "classpath:mybatis-config.xml"})
public class AdminMapperTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void test() {
        List<RoleInfo> roleInfos = adminService.queryRoleInfoName();
        roleInfos.forEach(System.out::println);
    }

}