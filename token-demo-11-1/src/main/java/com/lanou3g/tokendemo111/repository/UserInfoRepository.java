package com.lanou3g.tokendemo111.repository;

import com.lanou3g.tokendemo111.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author 铭
 * 2018/11/2 15:52
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByUsername(String username);

}
