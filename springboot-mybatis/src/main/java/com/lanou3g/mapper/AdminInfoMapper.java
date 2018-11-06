package com.lanou3g.mapper;

import com.lanou3g.entity.AdminInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminInfoMapper {
    @Select("SELECT * FROM admin_info")
    @Results({
            @Result(property = "adminId",column = "admin_id",javaType = AdminInfo.class),
            @Result(property = "adminName",column = "admin_name")
    })
    List<AdminInfo> findAll();


}
