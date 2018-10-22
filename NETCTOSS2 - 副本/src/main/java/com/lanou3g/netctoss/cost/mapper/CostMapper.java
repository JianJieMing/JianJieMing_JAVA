package com.lanou3g.netctoss.cost.mapper;

import com.lanou3g.netctoss.entity.Cost;

import java.util.List;

public interface CostMapper {

    List<Cost> findAll();

    int insertOne(Cost cost);

    int update(Integer integer);

    int delete(Integer integer);

    int updateAll(Cost cost);

    Cost findAllByid(Long costId);

    List<Cost> showAllBySortA();

    List<Cost> showAllBySortD();

    List<Cost> showAllBySorta();

    List<Cost> showAllBySortd();

    List<Cost> selectPage (Integer page);
}
