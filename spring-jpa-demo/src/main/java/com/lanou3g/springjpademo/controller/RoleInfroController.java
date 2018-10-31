package com.lanou3g.springjpademo.controller;

import com.lanou3g.springjpademo.entity.RoleEntity;
import com.lanou3g.springjpademo.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @RequestMapping("/list")
    public List<RoleEntity> list() {
        return roleRepository.findAll();
    }

}
