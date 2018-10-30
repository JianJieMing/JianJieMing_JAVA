package com.lanou3g.springredis.RoleService;

import com.lanou3g.springredis.entity.RoleInfo;

import java.util.List;
import java.util.Set;

/**
 * @author 铭
 * 2018/10/30 10:54
 */
public interface RoleService {

    List<RoleInfo> findAll();

    RoleInfo findOne(Long l);

    RoleInfo addOne(RoleInfo roleInfo);

    Boolean delete(Long roleId);

    public boolean thumb(Long roleId);

    public Set<?> thumbList();

}
