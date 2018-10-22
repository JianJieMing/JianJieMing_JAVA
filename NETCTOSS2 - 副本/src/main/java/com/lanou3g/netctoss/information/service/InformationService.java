package com.lanou3g.netctoss.information.service;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.information.controller.params.AdminInfoImpl;

public interface InformationService {
     void modify(AdminInfo adminInfo);
     AdminInfoImpl selectAll(AdminInfo adminInfo);
}
