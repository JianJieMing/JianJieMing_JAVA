package com.lanou3g.springredis.controller;

import com.lanou3g.springredis.RoleService.RoleService;
import com.lanou3g.springredis.entity.RoleInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author 铭
 * 2018/10/30 10:42
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/findAll")
    public List<RoleInfo> findAll() {
        List<RoleInfo> all = this.roleService.findAll();
        System.out.println(all + "**********");
        return all;
    }

    @RequestMapping("/findOne/{roleId}")
    public RoleInfo findOne(@PathVariable Long roleId) {
        RoleInfo one = this.roleService.findOne(roleId);
        return one;
    }

    @RequestMapping("/addOne")
    public Boolean addOne(RoleInfo roleInfo) {
        this.roleService.addOne(roleInfo);
        return true;
    }

    @RequestMapping("/delete/{roleId}")
    public Boolean delete(@PathVariable Long roleId) {
        return this.roleService.delete(roleId);
    }

    @RequestMapping("/like/{roleId}")
    public boolean like(@PathVariable Long roleId) {
        return this.roleService.thumb(roleId);
    }

    @RequestMapping("/thumbList")
    public Set<?> thumbList() {
        Set<?> set = this.roleService.thumbList();
        return set;
    }

}
