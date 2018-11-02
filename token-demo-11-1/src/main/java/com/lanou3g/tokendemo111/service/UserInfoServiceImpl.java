package com.lanou3g.tokendemo111.service;

import com.lanou3g.tokendemo111.entity.UserInfo;
import com.lanou3g.tokendemo111.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 铭
 * 2018/11/2 16:18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo login(String username, String password) {
        UserInfo userInfo = this.userInfoRepository.findByUsername(username);
        if (userInfo != null && userInfo.getPassword().equals(password)) {
            // 查询到了用户信息
            return userInfo;
        }
        return null;
    }
}
