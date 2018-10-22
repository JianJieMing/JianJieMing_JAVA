package com.lanou3g.netctoss.business.mapper;

import com.lanou3g.netctoss.business.controller.params.BusinessParams;
import com.lanou3g.netctoss.business.controller.params.ServiceCostParams;
import com.lanou3g.netctoss.entity.Account;
import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.entity.Service;

import java.util.List;

public interface BusinessMapper {

    List<Service> queryBusiness();

    List<Service> queryOsUsernameOrUnixHostOrIdCardNo(BusinessParams businessParams);

    Account queryIdCardNo(Account account);

    List<Cost> queryCostName();

    void insertService(Service service);

    void deleteAccount(Account account);

    void deleteService(Account account);

    void updateServiceCostId(ServiceCostParams params);

    void updateStatus(Service service);

    Service queryDetails(ServiceCostParams params);

}
