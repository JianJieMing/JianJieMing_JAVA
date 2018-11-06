package com.lanou3g.service;

import com.lanou3g.entity.AdminInfo;
import com.lanou3g.mapper.AdminInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 铭
 * 2018/11/5 19:52
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper mapper;

    @Override
    public List<AdminInfo> findAll() {
        return mapper.findAll();
    }
}
