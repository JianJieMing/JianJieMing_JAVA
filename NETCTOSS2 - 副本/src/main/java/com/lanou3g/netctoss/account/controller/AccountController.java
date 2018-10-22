package com.lanou3g.netctoss.account.controller;

import com.lanou3g.netctoss.account.service.AccountService;
import com.lanou3g.netctoss.entity.Account;
import com.lanou3g.netctoss.entity.Cost;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "/account/account_list";
    }

    @RequestMapping(value = "/updateStart")
    public String updateStart(HttpServletRequest request, Model model) {
        String accountId = request.getParameter("accountId");
        accountService.updateStart(Integer.valueOf(accountId));
        return findAll(model);
    }

    @RequestMapping(value = "/updateStop")
    public String updateStop(HttpServletRequest request, Model model) {
        String accountId = request.getParameter("accountId");
        accountService.updateStop(Integer.valueOf(accountId));
        System.out.println("---------------------");
        return findAll(model);
    }

    @RequestMapping(value = "/showMessage")
    public String showMessage(HttpServletRequest request, Model model) {
        String accountId = request.getParameter("accountId");
        Account account = accountService.showMessage(Integer.valueOf(accountId));
        model.addAttribute("accounts", account);
        return "/account/account_modi";
    }

    @RequestMapping(value = "/updateOne")
    public String updateOne(Account account, Model model) {
//        String accountId = request.getParameter("accountId");
        accountService.updateOne(account);
        return findAll(model);
    }


    @RequestMapping("/deleteOne")
    public String deleteOne(HttpServletRequest request, Model model) {
        String accountId = request.getParameter("accountId");
        accountService.deleteOne(Integer.valueOf(accountId));
        return findAll(model);
    }

    @RequestMapping(value = "/insertOne")
    public String insertOne(Account account, Model model,HttpServletRequest request) {
        accountService.insertOne(account);
        return findByPage(model,request);
    }

    @RequestMapping(value = "/selectOne")
    public String selectOne(Account account, Model model) {
        String status = account.getStatus();
        if (status.equals("0")) {
            List<Account> accounts = accountService.selectOne(account);
            model.addAttribute("accounts", accounts);
            return "/account/account_list";
        } else if (status.equals("1")) {
            List<Account> accounts = accountService.selectOne(account);
            model.addAttribute("accounts", accounts);
            return "/account/account_list";
        }
        List<Account> accounts = accountService.selectOneByMessage(account);
        model.addAttribute("accounts", accounts);
        return "/account/account_list";
    }

    @RequestMapping("/selectOneById")
    public String selectOneById(HttpServletRequest request, Model model) {
        String accountId = request.getParameter("accountId");
        System.out.println(accountId);
        Account account = accountService.selectOneById(Integer.valueOf(accountId));
        model.addAttribute("account", account);
        System.out.println("====================");
        return "/account/account_detail";
    }

    @RequestMapping("/findByPage")
    public String findByPage(Model model, HttpServletRequest request) {
        List<Account> all = accountService.findAll();
        int size = all.size();
        int totalPage = size / 5;
        if ((totalPage %= 5) != 0) {
            totalPage += 1;
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("accounts", all);
        if (request.getParameter("page") != null) {
            Integer page = Integer.valueOf(request.getParameter("page"));
            System.out.println(page);
            System.out.println(totalPage);
            if (page > 0 && page <= totalPage) {
                List<Account> accounts = accountService.selectPage((page - 1) * 5);
                model.addAttribute("accounts", accounts);
                model.addAttribute("page", page);
                return "/account/account_list";
            } else if (page >= totalPage) {
                List<Account> firstList = accountService.selectPage((totalPage - 1) * 5);
                model.addAttribute("accounts", firstList);
                model.addAttribute("page", totalPage);
                return "/account/account_list";
            }else if (page <=0){
                List<Account> firstList = accountService.selectPage(page);
                model.addAttribute("accounts", firstList);
                model.addAttribute("page",page);
                return "/account/account_list";
            }else {
                List<Account> firstList = accountService.selectPage(0);
                model.addAttribute("accounts", firstList);
                model.addAttribute("page",0);
                return "/account/account_list";
            }
        }
        else {
                List<Account> firstList = accountService.selectPage(0);
                model.addAttribute("accounts", firstList);
                model.addAttribute("page",0);
                return "/account/account_list";
        }
    }

}
