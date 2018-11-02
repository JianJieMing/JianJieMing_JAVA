package com.lanou3g.tokendemo111;

import com.lanou3g.tokendemo111.shiro.SimpleUsernameToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenDemo111ApplicationTests {

    @Test
    public void contextLoads() {

        Subject subject = SecurityUtils.getSubject();
        subject.login(new SimpleUsernameToken("ady", "ady"));
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("money");
        roles.add("staff");
        String[] permissions = {"admin:delete", "admin:query", "money:create", "money:query"};
        boolean[] permitted = subject.isPermitted(permissions);
        boolean[] booleans = subject.hasRoles(roles);
        System.out.println(Arrays.toString(booleans));
        System.out.println("********************");
        System.out.println(Arrays.toString(permitted));

    }

}
