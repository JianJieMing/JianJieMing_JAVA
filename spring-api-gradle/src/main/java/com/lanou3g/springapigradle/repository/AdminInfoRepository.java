package com.lanou3g.springapigradle.repository;

import com.lanou3g.springapigradle.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * @author 铭
 * 2018/10/31 10:20
 */
@RepositoryRestResource(path = "adminList")
public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long> {
}
