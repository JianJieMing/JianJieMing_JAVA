package com.lanou3g.springbootdemo.mapper;

import com.lanou3g.springbootdemo.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 铭
 * 2018/10/30 10:52
 */
public interface RoleMapper extends JpaRepository<RoleInfo,Long> {


}
