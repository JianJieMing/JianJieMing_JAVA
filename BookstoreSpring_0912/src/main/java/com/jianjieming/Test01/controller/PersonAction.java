package com.jianjieming.Test01.controller;

import com.jianjieming.Test01.Modle.service.PersonService;
import com.jianjieming.Test01.Modle.vo.Animal;
import com.jianjieming.Test01.Modle.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午8:20
 */
@Controller
public class PersonAction {
    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonAction person = (PersonAction) context.getBean("personAction");
        List<Animal> animals = person.personService.showAll();
        Person person1 = (Person) context.getBean("person");
        person1.setAnimal(animals);
        System.out.println(person1);
    }
}
/*

Dispatcher(调度)
Handler(处理)
Mapping(映射)
Adapter(适配器)
第一步:
客户端向服务器发送请求,url数据.

第二步:
整个服务器端通过DispatcherServlet(Controller)进行调度,
查找相应的HandlerMapping(映射处理器),把url+数据,封装成数据对象.

第三步:
HandlerAdapter(是后台controller的核心部分,所以写代码时通常写成controller)(适配器),
对于数据对象进行业务处理,封装成ModelAndView对象.

第四步:
ViewResolver(视图解析器),对ModelAndView进行解析,把model渲染到view上面.

第五步:
把view响应回客户端.

*/
