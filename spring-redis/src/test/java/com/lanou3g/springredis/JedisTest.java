package com.lanou3g.springredis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 铭
 * 2018/10/30 9:37
 */
public class JedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
        jedis.close();

        // 构造方法不填参数的时候,默认的url就是127.0.0.1:6379
        JedisPool pool = new JedisPool();
        Jedis jedis1 = pool.getResource();
        String mset = jedis1.mset("a", "1", "b", "2", "c", "3", "d", "4");
        System.out.println(mset);
        jedis1.close();
    }

}
