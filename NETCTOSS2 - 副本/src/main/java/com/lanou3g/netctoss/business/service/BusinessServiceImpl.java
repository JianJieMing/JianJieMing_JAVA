package com.lanou3g.netctoss.business.service;

import com.lanou3g.netctoss.business.controller.params.BusinessParams;
import com.lanou3g.netctoss.business.controller.params.ServiceCostParams;
import com.lanou3g.netctoss.business.mapper.BusinessMapper;
import com.lanou3g.netctoss.entity.Account;
import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.entity.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 铭
 * 2018/10/15 11:29
 */
@org.springframework.stereotype.Service
public class BusinessServiceImpl implements BusinessService{

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public List<Service> queryBusiness() {
        List<Service> tservices = businessMapper.queryBusiness();
        return tservices;
    }

    @Override
    public List<Service> queryOsUsernameOrUnixHostOrIdCardNo(BusinessParams businessParams) {
        List<Service> serviceList = businessMapper.queryOsUsernameOrUnixHostOrIdCardNo(businessParams);
        return serviceList;
    }

    @Override
    public Account queryIdCardNo(Account account) {
        Account account1 = businessMapper.queryIdCardNo(account);
        return account1;
    }

    @Override
    public List<Cost> queryCostName() {
        List<Cost> costs = businessMapper.queryCostName();
        return costs;
    }

    @Transactional
    @Override
    public void insertServiceCost(ServiceCostParams params) {
        Service service = new Service();
        service.setAccountId(params.getAccountId());
        service.setUnixHost(params.getUnixHost());
        service.setOsUsername(params.getOsUsername());
        service.setLoginPasswd(params.getLoginPasswd());
        service.setCostId(params.getCostId());
        businessMapper.insertService(service);
    }

    @Transactional
    @Override
    public void deleteAccountAndService(Account account) {
        businessMapper.deleteAccount(account);
        businessMapper.deleteService(account);
    }

    @Transactional
    @Override
    public void updateServiceCostId(ServiceCostParams params) {
        businessMapper.updateServiceCostId(params);
    }

    @Transactional
    @Override
    public void updateStatus(Service service) {
        businessMapper.updateStatus(service);
    }

    @Override
    public Service queryDetails(ServiceCostParams params) {
        Service services = businessMapper.queryDetails(params);
        return services;
    }


}
