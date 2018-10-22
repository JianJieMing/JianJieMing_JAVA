package com.lanou3g.netctoss.cost.controller;

import com.lanou3g.netctoss.entity.Account;
import com.lanou3g.netctoss.entity.Cost;
import com.lanou3g.netctoss.cost.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cost")
public class CostController {


    @Autowired
    private CostService costService;

    @RequestMapping("/view")
    public String view() {
        return "/fee/fee_list";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Cost> costList = costService.findAll();
        model.addAttribute("costList", costList);
        return "/fee/fee_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insertOne(Cost cost, Model model,HttpServletRequest request) {
        costService.insertOne(cost);
        return findByPage(model,request);
    }

    @RequestMapping("/update")
    public String update(Model model, HttpServletRequest request) {
        String num = request.getParameter("num");
        costService.update(Integer.valueOf(num));
        System.out.println(num);
        return findAll(model);
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        String num = request.getParameter("num");
        costService.delete(Integer.valueOf(num));
        return findAll(model);
    }

    @RequestMapping("/showAll")
    public String showAll(Model model, HttpServletRequest request) {
        String costId1 = request.getParameter("costId");
        Cost cost = costService.findAllByid(Long.valueOf(costId1));
        model.addAttribute("cost", cost);
        return "/fee/fee_modi";
    }

    @RequestMapping("/showAllByname")
    public String showAllByname(Model model, HttpServletRequest request) {
        String costId1 = request.getParameter("costId");
        Cost cost = costService.findAllByid(Long.valueOf(costId1));
        model.addAttribute("cost", cost);
        return "/fee/fee_detail";
    }

    @RequestMapping("/updateAll")
    public String updateAll(Model model, Cost cost, HttpServletRequest request) {
//        String costId1 = request.getParameter("costId");
        costService.updateAll(cost);
        return findAll(model);
    }

    @RequestMapping("/sort")
    @ResponseBody
    public List<Cost> sortAll(Model model, HttpServletRequest request) {
        String num = request.getParameter("num");
        System.out.println(num+"============");
        if (num.equals("1")) {
            return costService.showAllBySortA();
        } else if (num.equals("2")) {
            return costService.showAllBySortD();
        } else if (num.equals("3")) {
            return costService.showAllBySorta();
        } else {
            return costService.showAllBySortd();
        }
    }

    @RequestMapping("/findByPage")
    public String findByPage(Model model, HttpServletRequest request) {
        List<Cost> all = costService.findAll();
        int size = all.size();
        int totalPage = size / 5;
        if ((totalPage %= 5) != 0) {
            totalPage += 1;
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("costList", all);
        if (request.getParameter("page") != null) {
            Integer page = Integer.valueOf(request.getParameter("page"));
            System.out.println(page);
            System.out.println(totalPage);
            if (page > 0 && page <= totalPage) {
                List<Cost> costs = costService.selectPage((page - 1) * 5);
                model.addAttribute("costList", costs);
                model.addAttribute("page", page);
                return "/fee/fee_list";
            } else if (page >= totalPage) {
                List<Cost> firstList = costService.selectPage((totalPage - 1) * 5);
                model.addAttribute("costList", firstList);
                model.addAttribute("page", totalPage);
                return "/fee/fee_list";
            } else if (page <= 0) {
                List<Cost> firstList = costService.selectPage(page);
                model.addAttribute("costList", firstList);
                model.addAttribute("page", page);
                return "/fee/fee_list";
            } else {
                List<Cost> firstList = costService.selectPage(0);
                model.addAttribute("costList", firstList);
                model.addAttribute("page", 0);
                return "/fee/fee_list";
            }
        } else {
            List<Cost> firstList = costService.selectPage(0);
            model.addAttribute("costList", firstList);
            model.addAttribute("page", 0);
            return "/fee/fee_list";
        }
    }
}
