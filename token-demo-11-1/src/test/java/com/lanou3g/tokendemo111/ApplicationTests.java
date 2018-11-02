package com.lanou3g.tokendemo111;

import com.lanou3g.tokendemo111.entity.SysRole;
import com.lanou3g.tokendemo111.entity.UserInfo;
import com.lanou3g.tokendemo111.repository.UserInfoRepository;
import com.lanou3g.tokendemo111.shiro.SimpleUsernameToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Test
    public void contextLoads() {

        UserInfo jan = userInfoRepository.findByUsername("jan");
        for (SysRole role : jan.getRoleList()) {
            System.out.println(role.getRole());
        }


    }

}
