package com.lanou3g.springbootdemo.controller;

import com.lanou3g.springbootdemo.entity.AdminInfo;
import com.lanou3g.springbootdemo.mapper.AdminInfoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author 铭
 * 2018/10/20 9:54
 */
@RestController
public class AdminInfoController {

    @Autowired
    private AdminInfoJPA adminInfoJPA;

    @RequestMapping("/admin_list")
    public Optional<AdminInfo> showAll() {
        return adminInfoJPA.findById(10087L);
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(AdminInfo adminInfo) {
        System.out.println(adminInfo);
       return "login";
    }

    /**
     * 分页查询测试
     * @param page 传入页码，从1开始
     * @return
     */
    @RequestMapping(value = "/cutpage")
    public List<AdminInfo> cutPage(int page)
    {
        AdminInfo admin = new AdminInfo();
        admin.setSize(2);
        admin.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(admin.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, admin.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(admin.getPage() - 1,admin.getSize(),sort);
        //执行分页查询
        return adminInfoJPA.findAll(pageRequest).getContent();
    }

}
