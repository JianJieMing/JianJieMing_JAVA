package com.lanou3g.springjpademo.repository;

import com.lanou3g.springjpademo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 铭
 * 2018/10/31 17:50
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query(value = "select * from role_info", nativeQuery = true)
    List<RoleEntity> roles();

}
