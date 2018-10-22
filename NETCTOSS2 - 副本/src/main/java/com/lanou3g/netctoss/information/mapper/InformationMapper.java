package com.lanou3g.netctoss.information.mapper;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.information.controller.params.AdminInfoImpl;

public interface InformationMapper {
     void modify(AdminInfo adminInfo);
     AdminInfoImpl selectAll(AdminInfo adminInfo);
}
