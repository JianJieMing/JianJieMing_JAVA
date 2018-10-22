package com.lanou3g.springbootdemo.mapper;

import com.lanou3g.springbootdemo.entity.ModuleInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleInfoMapper {

    @Select("SELECT * FROM module_info")
    @Results({
            @Result(column = "module_id",property = "moduleId",javaType = ModuleInfo.class),
            @Result(column = "name",property = "name")
    })
    List<ModuleInfo> showAll();

}
