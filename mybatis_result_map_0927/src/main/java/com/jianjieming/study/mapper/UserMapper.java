package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbUser;

import java.util.List;

/**
 * @author 铭
 * 2018/9/27 9:56
 */
public interface UserMapper {

    /**
     * 查询所有人,然后携带所有信息
     * 人-->订单-->商品-->类别
     * @return
     */
    List<TbUser> findAllStrong();

}
