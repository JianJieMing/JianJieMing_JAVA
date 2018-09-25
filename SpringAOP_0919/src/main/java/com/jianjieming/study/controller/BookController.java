package com.jianjieming.study.controller;

import com.jianjieming.study.bean.BookBean;
import com.jianjieming.study.exception.JspException;
import com.jianjieming.study.vaildate.BookUpdateVaildator;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
        System.out.println("BookController.newBook");
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

    @RequestMapping("/test")
    public String test(int id) {
        if (id > 5) {
//            throw new JsonException("ID超出异常",400);
            throw new JspException();
        }
        return "success";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("bookImage") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String name = file.getName();
        String filename = file.getOriginalFilename();
        String contentType = file.getContentType();
        long size = file.getSize();
        System.out.println("key = " + name);
        System.out.println("文件名 = " + filename);
        System.out.println("文件类型 = " + contentType);
        System.out.println("文件大小 = " + size);
        ServletContext context = request.getServletContext();
        String images = context.getRealPath("images");
        File file1 = new File(images);
        file1.mkdirs();
        File file2 = new File(file1, filename);
        FileUtils.copyInputStreamToFile(file.getInputStream(), file2);
        return "success";
    }

}
