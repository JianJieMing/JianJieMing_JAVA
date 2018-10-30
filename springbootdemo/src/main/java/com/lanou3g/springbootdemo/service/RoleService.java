package com.lanou3g.springbootdemo.service;

import com.lanou3g.springbootdemo.entity.RoleInfo;

import java.util.List;

/**
 * @author 铭
 * 2018/10/30 10:54
 */
public interface RoleService {

    List<RoleInfo> findAll();

    RoleInfo findOne(Long l);

    Boolean addOne(RoleInfo roleInfo);

    Boolean delete(Long roleId);


}
