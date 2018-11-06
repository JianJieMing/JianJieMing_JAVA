package com.lanou3g.controller;

import com.lanou3g.entity.AdminInfo;
import com.lanou3g.service.AdminInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 铭
 * 2018/11/5 19:53
 */
@RestController
public class AdminInfoController {

    @Resource
    private AdminInfoService adminInfoService;

    @RequestMapping("/findAll")
    public List<AdminInfo> findAll() {
        return adminInfoService.findAll();
    }

}
