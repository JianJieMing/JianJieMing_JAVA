package com.lanou3g.tokendemo111.service;

import com.lanou3g.tokendemo111.entity.UserInfo;

/**
 * @author 铭
 * 2018/11/2 16:17
 */
public interface UserInfoService {

    UserInfo login(String username, String password);

}
