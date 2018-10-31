package com.lanou3g.springapigradle.repository;

import com.lanou3g.springapigradle.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


/**
 * @author 铭
 * 2018/10/31 10:20
 */
@RepositoryRestResource(path = "roleList")
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {

    @RestResource(path = "findByName")
    List<RoleInfo> findByNameContains(@Param("name") String name);

    @RestResource(path = "findByIdBetween")
    List<RoleInfo> findByRoleIdBetween(@Param("start") Long start,@Param("end") Long end);

}
