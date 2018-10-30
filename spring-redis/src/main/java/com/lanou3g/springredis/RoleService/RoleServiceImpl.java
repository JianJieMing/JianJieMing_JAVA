package com.lanou3g.springredis.RoleService;

import com.lanou3g.springredis.entity.RoleInfo;
import com.lanou3g.springredis.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author 铭
 * 2018/10/30 11:00
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Cacheable(value = "roleService")
    @Override
    public List<RoleInfo> findAll() {
        System.out.println("RoleServiceImpl.findAll");
        List<RoleInfo> all = this.mapper.findAll();
        return all;
    }

    @Cacheable(value = "roleService", key = "#roleId")
    @Override
    public RoleInfo findOne(Long l) {
        System.out.println("RoleServiceImpl.findOne");
        RoleInfo one = this.mapper.findById(l).get();
        return one;
    }

    // 这个key是重返回值中拿到插入之后的数据,是在redis中的缓存中拿到的
    @CachePut(value = "roleService", key = "#roleInfo.roleId")
    @Override
    public RoleInfo addOne(RoleInfo roleInfo) {
        System.out.println("RoleServiceImpl.addOne");
        RoleInfo save = this.mapper.save(roleInfo);
        return save;
    }

    // 清空所有缓存(卡死以为的,奥恩退思)
    @CacheEvict(value = "roleService", allEntries = true)
    @Override
    public Boolean delete(Long roleId) {
        System.out.println("RoleServiceImpl.delete");
        this.mapper.deleteById(roleId);
        return true;
    }

    public boolean thumb(Long roleId) {
        ZSetOperations<Object, Object> forZSet = this.redisTemplate.opsForZSet();
        RoleInfo one = findOne(roleId);
        forZSet.incrementScore("thumb:roleId", one, 1);
        return true;
    }

    public Set<?> thumbList() {
        ZSetOperations<Object, Object> opsForZSet = this.redisTemplate.opsForZSet();
        Set<Object> set = opsForZSet.reverseRange("thumb:roleId", 0, 2);
        Set<ZSetOperations.TypedTuple<Object>> scores =
                opsForZSet.reverseRangeWithScores("thumb:roleId", 0, 2);
        return scores;
    }

}
