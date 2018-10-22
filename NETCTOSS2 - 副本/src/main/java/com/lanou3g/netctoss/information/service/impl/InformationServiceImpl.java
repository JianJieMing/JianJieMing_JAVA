package com.lanou3g.netctoss.information.service.impl;

import com.lanou3g.netctoss.entity.AdminInfo;
import com.lanou3g.netctoss.information.controller.params.AdminInfoImpl;
import com.lanou3g.netctoss.information.mapper.InformationMapper;
import com.lanou3g.netctoss.information.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class InformationServiceImpl implements InformationService {
    @Resource
    private InformationMapper informationMapper;

    @Transactional
    @Override
    public void modify(AdminInfo adminInfo) {
        informationMapper.modify(adminInfo);
    }

    @Override
    public AdminInfoImpl selectAll(AdminInfo adminInfo) {
        return informationMapper.selectAll(adminInfo);
    }

}
