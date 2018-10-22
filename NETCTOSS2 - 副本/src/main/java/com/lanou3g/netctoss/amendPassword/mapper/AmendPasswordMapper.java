package com.lanou3g.netctoss.amendPassword.mapper;

import com.lanou3g.netctoss.entity.AdminInfo;

public interface AmendPasswordMapper {

    void modifyPassword(AdminInfo adminInfo);

    AdminInfo selectPassword(AdminInfo adminInfo);
}
