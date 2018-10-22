package com.lanou3g.netctoss.login.mapper;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.entity.AdminInfoQx;

import java.util.List;

public interface AdminInfoMapper {

    AdminInfo findOne(String adminCode);

    AdminInfoQx showModule(String adminCode);
}
