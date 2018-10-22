package com.lanou3g.netctoss.business.controller;

import com.lanou3g.netctoss.business.controller.params.BusinessParams;
import com.lanou3g.netctoss.business.controller.params.ServiceCostParams;
import com.lanou3g.netctoss.business.service.BusinessService;
import com.lanou3g.netctoss.entity.Account;
import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 铭
 * 2018/10/15 11:34
 */
@Controller
@RequestMapping("service")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/service_list", method = RequestMethod.GET)
    public String serviceList() {
        return "/service/service_list";
    }

    @ResponseBody
    @RequestMapping(value = "/queryBusiness", method = RequestMethod.GET)
    public List<Service> queryBusiness() {
        List<Service> tservices = businessService.queryBusiness();
        tservices.forEach(System.out::println);
        return tservices;
    }

    @ResponseBody
    @RequestMapping(value = "/queryOsUsernameOrUnixHostOrIdCardNo", method = RequestMethod.POST)
    public List<Service> queryOsUsernameOrUnixHostOrIdCardNo(@RequestBody BusinessParams params) {
        List<Service> serviceList = businessService.queryOsUsernameOrUnixHostOrIdCardNo(params);
        return serviceList;
    }

    @ResponseBody
    @RequestMapping(value = "/queryIdCardNo", method = RequestMethod.POST)
    public Account queryIdCardNo(@RequestBody Account account) {
        Account account1 = businessService.queryIdCardNo(account);
        return account1;
    }

    @ResponseBody
    @RequestMapping(value = "/queryCostName", method = RequestMethod.GET)
    public List<Cost> queryCostName() {
        List<Cost> costs = businessService.queryCostName();
        return costs;
    }

    @RequestMapping(value = "/insertServiceCost", method = RequestMethod.POST)
    public String insertServiceCost(@RequestBody ServiceCostParams params) {
        businessService.insertServiceCost(params);
        return "/service/service_list";
    }

    @RequestMapping(value = "/deleteAccountAndService", method = RequestMethod.POST)
    public String deleteAccountAndService(@RequestBody Account account) {
        System.out.println(account.getAccountId());
        businessService.deleteAccountAndService(account);
        return "/service/service_list";
    }

    @ResponseBody
    @RequestMapping(value = "/updateServiceCostId", method = RequestMethod.POST)
    public String updateServiceCostId(@RequestBody ServiceCostParams params) {
        businessService.updateServiceCostId(params);
        return "/service/service_list";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String updateStatus(@RequestBody Service service) {
        businessService.updateStatus(service);
        return "/service/service_list";
    }

    @RequestMapping(value = "/queryDetails", method = RequestMethod.POST)
    @ResponseBody
    public Service queryDetails(@RequestBody ServiceCostParams params) {
        System.out.println(params.getServiceId());
        Service services = businessService.queryDetails(params);
        return services;
    }

}
