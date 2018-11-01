package com.lanou3g.springjpademo.repository;

import com.lanou3g.springjpademo.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author 铭
 * 2018/11/1 9:39
 */
@Repository
public class RoleInfoRepositoryImpl {

    @Resource
    private EntityManager entityManager;

    public List<?> queryTest() {
        String sql = "select * from role_info";
        Query namedQuery = entityManager.createNativeQuery(sql, RoleEntity.class);
        List resultList = namedQuery.getResultList();
        return resultList;
    }

}
