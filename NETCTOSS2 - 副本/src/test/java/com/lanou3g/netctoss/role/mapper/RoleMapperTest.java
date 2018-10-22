package com.lanou3g.netctoss.role.mapper;

import com.lanou3g.netctoss.entity.ModuleInfo;
import com.lanou3g.netctoss.entity.RoleInfoQx;
import com.lanou3g.netctoss.role.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml","classpath:mybatis-config.xml"})
public class RoleMapperTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void test(){
        List<RoleInfoQx> roleInfos = roleService.queryUserAndPermissions();
        roleInfos.forEach(System.out::println);
        System.out.println("******************");
        List<ModuleInfo> moduleInfos = roleService.queryModuleName();
        System.out.println(moduleInfos);
    }


}