package com.lanou3g.springjpademo.controller;

import com.lanou3g.springjpademo.entity.RoleEntity;
import com.lanou3g.springjpademo.repository.RoleInfoRepository;
import com.lanou3g.springjpademo.repository.temp.RoleEx;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 铭
 * 2018/10/31 17:49
 */
@RestController
public class RoleInfroController {

    @Resource
    private RoleInfoRepository roleRepository;

    @RequestMapping("/list")
    public List<RoleEntity> list() {
        return roleRepository.findAll();
    }

    @RequestMapping("/listGroup")
    public List<RoleEx> listGroup() {
        return roleRepository.roleGroup();
    }

    @RequestMapping("/autoList")
    public List<?> queryTest() {
        return roleRepository.queryTest();
    }

}
