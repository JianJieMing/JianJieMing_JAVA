package com.lanou3g.springredis.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.text.SimpleDateFormat;

/**
 * @author 铭
 * 2018/10/30 16:38
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template
                = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 定制Jackson,关于更多配置,自己查,比如对象的null属性是否序列化,比如是否转出更美观的json格式.
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        //通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
        //Include.Include.ALWAYS 默认
        //Include.NON_DEFAULT 属性为默认值不序列化
        //Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
        //Include.NON_NULL 属性为NULL 不序列化
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        // 把value序列化成json格式.
        template.setValueSerializer(serializer);
        // 把对象序列化成字符串.
        template.setKeySerializer(serializer); // 转json
//        template.setKeySerializer(new StringRedisSerializer());
        // 文件里的配置也会加载.
        template.afterPropertiesSet();
        return template;
    }

}
