package com.lanou3g.springjpademo.repository;

import com.lanou3g.springjpademo.entity.RoleEntity;
import com.lanou3g.springjpademo.repository.temp.RoleEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.management.relation.RoleInfo;
import java.util.List;

/**
 * @author 铭
 * 2018/10/31 17:50
 */
public interface RoleInfoRepository extends JpaRepository<RoleEntity, Long> {

    // 自定义查询
    @Query(value = "select * from role_info", nativeQuery = true)
    List<RoleEntity> roles();

    // HQL
    @Query("select role from RoleEntity role")
    List<RoleInfo> roleTest();

    @Query(value = "select r.role_id as roleId," +
            " r.role_name as roleName, " +
            "count(rm.temp_module_id) as moduleCount\n" +
            "from role_info r\n" +
            "       left join role_module rm " +
            "on r.role_id = rm.temp_role_id\n" +
            "group by r.role_id", nativeQuery = true)
    List<RoleEx> roleGroup();


    List<?> queryTest();

}
