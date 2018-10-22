package com.lanou3g.springbootdemo.mapper;

import com.lanou3g.springbootdemo.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 铭
 * 2018/10/19 19:12
 */
public interface AdminInfoJPA extends JpaRepository<AdminInfo,Long> {

}
