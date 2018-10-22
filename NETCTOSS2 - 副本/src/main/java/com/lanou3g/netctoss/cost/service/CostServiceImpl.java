package com.lanou3g.netctoss.cost.service;

import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.cost.mapper.CostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    @Override
    public List<Cost> findAll() {
        List<Cost> all = costMapper.findAll();
        return all;
    }

    @Transactional
    @Override
    public int insertOne(Cost cost) {
        return costMapper.insertOne(cost);
    }

    @Transactional
    @Override
    public int update(Integer integer) {
        return costMapper.update(integer);
    }

    @Transactional
    @Override
    public int delete(Integer integer) {
        return costMapper.delete(integer);
    }

    @Transactional
    @Override
    public int updateAll(Cost cost) {
        return costMapper.updateAll(cost);
    }

    @Override
    public Cost findAllByid(Long costId) {
        return costMapper.findAllByid(costId);
    }

    @Override
    public List<Cost> showAllBySortA() {
        return costMapper.showAllBySortA();
    }

    @Override
    public List<Cost> showAllBySortD() {
        return costMapper.showAllBySortD();
    }

    @Override
    public List<Cost> showAllBySorta() {
        return costMapper.showAllBySorta();
    }

    @Override
    public List<Cost> showAllBySortd() {
        return costMapper.showAllBySortd();
    }

    @Override
    public List<Cost> selectPage(Integer page) {
        return costMapper.selectPage(page);
    }
}
