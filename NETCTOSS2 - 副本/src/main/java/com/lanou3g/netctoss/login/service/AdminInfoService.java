package com.lanou3g.netctoss.login.service;


import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.entity.AdminInfoQx;

import java.util.List;

public interface AdminInfoService {

    AdminInfo findOne(AdminInfo adminInfo);

    AdminInfoQx showModule(String adminCode);
}
