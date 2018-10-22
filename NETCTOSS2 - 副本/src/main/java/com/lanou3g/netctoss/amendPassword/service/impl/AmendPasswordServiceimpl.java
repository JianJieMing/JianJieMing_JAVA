package com.lanou3g.netctoss.amendPassword.service.impl;

import com.lanou3g.netctoss.amendPassword.mapper.AmendPasswordMapper;
import com.lanou3g.netctoss.amendPassword.service.AmendPasswordService;
import com.lanou3g.netctoss.entity.AdminInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AmendPasswordServiceimpl implements AmendPasswordService {

    @Resource
    private AmendPasswordMapper amendPasswordMapper;


    @Transactional
    @Override
    public void modifyPassword(AdminInfo adminInfo) {
        amendPasswordMapper.modifyPassword(adminInfo);
    }

    @Override
    public AdminInfo selectPassword(AdminInfo adminInfo) {
        AdminInfo adminInfo1 = amendPasswordMapper.selectPassword(adminInfo);
        return adminInfo1;
    }
}
