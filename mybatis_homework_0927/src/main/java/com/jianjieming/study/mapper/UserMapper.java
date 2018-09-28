package com.jianjieming.study.mapper;

import com.jianjieming.study.entity.TbUser;
import com.jianjieming.study.entity.UserMoney;

import java.util.List;
import java.util.Map;

/**
 * @author 铭
 * 2018/9/27 23:18
 */
public interface UserMapper {

    List<UserMoney> userMoney();

    //  进行多条件查询
    List<TbUser> findAllCondition(Map<String, Object> objectMap);

    List<TbUser> findAll(Map<String, Object> objectMap);

    // 根据userId更新一条数据
    int updateOne(TbUser user);

    // 根据userId更新集合中的所有User对象
    default int updateUsers(List<TbUser> users){
        int s = 0;
        for (TbUser user : users) {
            updateOne(user);
            s++;
        }
        return s;
    }

    // 将集合中所有userId对应的数据都删除掉
    int deleteByUserIds(List<Integer> ids);

    int addUsers(List<TbUser> users);

}
