package com.jianjieming.study.controller;

import com.jianjieming.study.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/17 下午5:42
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解.
 * Restful 它是一种url的设计规则.
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解.
 * Restful 它是一种url的设计规则.
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解.
 * Restful 它是一种url的设计规则.
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解.
 * Restful 它是一种url的设计规则.
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解
 * Restful 它是一种url的设计规则
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * <p>
 * /book?id=1 -> /book/1 查询某一本书
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解
 * Restful 它是一种url的设计规则
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 * <p>
 * /book?id=1 -> /book/1 查询某一本书
 */

/**
 * @RestController 注解标记的Controller
 * 里面所有请求都自动加上了ResponseBody注解
 * Restful 它是一种url的设计规则
 * /add_user -> /user put
 * /delete_user -> /user delete
 * /update_user -> /user post
 * /find_user -> /user get
 *
 * /book?id=1 -> /book/1 查询某一本书
 */


/**
 * 查询所有用户
 */
@RestController
public class PersonController {
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> findAll(
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int count) {
        return null;
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    public Person delete() {
        return null;
    }

    // /dlj0603/1001
    @RequestMapping(value = "/person/{id}/{name}", method = RequestMethod.GET)
    public Person findOne(@PathVariable int id,@PathVariable String name) {
        Person p = new Person();
        p.setId(id);
        p.setName("李四");
        return p;
    }
}
