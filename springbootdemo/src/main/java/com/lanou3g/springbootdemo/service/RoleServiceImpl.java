package com.lanou3g.springbootdemo.service;

import com.lanou3g.springbootdemo.entity.RoleInfo;
import com.lanou3g.springbootdemo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 铭
 * 2018/10/30 11:00
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public List<RoleInfo> findAll() {
        List<RoleInfo> all = this.mapper.findAll();
        System.out.println(all+"*********************???");
        return all;
    }

    @Override
    public RoleInfo findOne(Long l) {
        RoleInfo one = this.mapper.findById(l).get();
        return one;
    }

    @Override
    public Boolean addOne(RoleInfo roleInfo) {
        this.mapper.save(roleInfo);
        return true;
    }

    @Override
    public Boolean delete(Long roleId) {
        this.mapper.deleteById(roleId);
        return true;
    }
}
