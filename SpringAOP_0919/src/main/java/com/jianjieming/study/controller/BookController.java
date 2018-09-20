package com.jianjieming.study.controller;

import com.jianjieming.study.bean.BookBean;
import com.jianjieming.study.vaildate.BookAdd;
import com.jianjieming.study.vaildate.BookUpdateVaildator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    /*
        数据校验:
            1. 需要人为的判断哪些属性需要做校验.
            2. 这些属性各自需要怎么样的校验规则.
            3. 如果校验不通过,要提示什么信息.
            4. 这个信息如何发送给用户.
     */
    @RequestMapping("/add")
    public String newBook(@Validated BookBean book, BindingResult result, Model model) {
        // 这个对象用来获取校验不通过的信息
        // 必须写在被校验实体类的后面
        // 这俩必须得挨着
        if (result.hasErrors()) {
            // 针对某个属性获取它的校验信息
            FieldError bookName = result.getFieldError("bookName");
            // 针对某个属性获取它的所有校验的错误信息
            List<FieldError> price = result.getFieldErrors("price");
            // 获取所有属性的所有校验错误信息.
            List<FieldError> errors = result.getFieldErrors();
            // 如果出错,把错误集合放到Model中
            model.addAttribute("errors", errors);
            for (FieldError error : errors) {
                String message = error.getDefaultMessage();
                System.out.println(message);
            }
            return "error";
        } else {
            return "success";
        }
    }

    @RequestMapping("/update")
    public String updateBook(@Validated(value = {BookUpdateVaildator.class}) BookBean book, BindingResult result, Model model) {
        // 更新书本的方法
        // 该方法与新增书本的方法使用的都是同一个实体对象
        // 但是在不同的方法中,校验的规则是不同的
        return newBook(book, result, model);
    }

}
