package com.lanou3g.springredis;

import com.lanou3g.springredis.entity.RoleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    @Test
    public void contextLoads() {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(1000L);
        roleInfo.setName("孙悟空");
        valOps.set(roleInfo, "男");
        System.out.println(valOps.get(roleInfo));
    }

}
