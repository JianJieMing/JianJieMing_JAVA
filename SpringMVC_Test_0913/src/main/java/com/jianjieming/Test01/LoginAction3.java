package com.jianjieming.Test01;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 铭
 * DATE: 18/9/13 下午4:30
 */
//@Controller
public class LoginAction3 {
    @RequestMapping("/login.action")
    public ModelAndView success() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");

        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/success.action")
//    public ModelAndView success(Person person) {
//        System.out.println(person);
//
//        Map map = new HashMap();
//        map.put("person", person);
//
//        ModelAndView mav = new ModelAndView("success", map);
//        return mav;
//
//    }
    /*
    如果返回值是String类型,容器会帮助我们封装成ModelAndView,此时的viewName就是String.
    如果想要传递Model,可以使用参数Model/Map/ModelMap
     */
//    public String success(Person person, Map map) {
//        map.put("person", person);
//        return "success";
//    }

//    public String success(Person person, Model map) {
//        map.addAttribute("person",person);
//        return "success";
//    }

//    public String success(Person person, ModelMap map) {
//        map.addAttribute("person",person);
//        return "success";
//    }

    // @ModelAttribute这个注解就相当于,Model.addAttribute("person",person);
    public String success(@ModelAttribute("person") Person person) {
        return "success";
    }
}
