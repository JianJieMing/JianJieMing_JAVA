package com.jianjieming.study.bean;

import com.jianjieming.study.vaildate.BookAdd;
import com.jianjieming.study.vaildate.BookUpdateVaildator;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.sql.Date;

public class BookBean {

    // 这条属性在更新书本的方法中是需要校验的
    // 但是,在新增书本的方法中是不需要校验的
    @NotNull(message = "id不能为空", groups = {BookUpdateVaildator.class})
    private Integer id;

    @NotBlank(message = "书名不能为空",groups = {BookAdd.class})
    private String bookName;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotNull(message = "价钱不能为空")
    @Min(value = 0, message = "价钱必须大于0")
    @Digits(integer = 10, fraction = 2, message = "设置的价钱不合理")
    private Float price;

    @NotNull(message = "时间不能为空")
    @Past(message = "时间必须是过去的时间")
//    @Future（） 时间必须是未来的时间
    private Date publishDate;

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
