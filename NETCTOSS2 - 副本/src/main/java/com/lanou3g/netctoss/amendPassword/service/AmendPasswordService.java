package com.lanou3g.netctoss.amendPassword.service;

import com.lanou3g.netctoss.amendPassword.controller.parmens.PasswordParmens;
import com.lanou3g.netctoss.entity.AdminInfo;

public interface AmendPasswordService {

    void modifyPassword(AdminInfo adminInfo);

    AdminInfo selectPassword(AdminInfo adminInfo);
}
