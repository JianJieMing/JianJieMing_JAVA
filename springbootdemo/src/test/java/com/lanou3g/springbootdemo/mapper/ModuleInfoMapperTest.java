package com.lanou3g.springbootdemo.mapper;

import com.lanou3g.springbootdemo.entity.ModuleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleInfoMapperTest {

    @Resource
    private ModuleInfoMapper moduleInfoMapper;

    @Test
    public void showAll(){
        List<ModuleInfo> moduleInfos = moduleInfoMapper.showAll();
        moduleInfos.forEach(System.out::println);
    }

}