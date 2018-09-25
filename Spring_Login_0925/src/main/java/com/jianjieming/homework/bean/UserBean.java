package com.jianjieming.homework.bean;

import com.jianjieming.homework.rule.LoginRule;
import com.jianjieming.homework.rule.RegisterRule;
import com.jianjieming.homework.validator.IdCard;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author 铭
 * 2018/9/25 9:36
 */
public class UserBean {
    @NotBlank(message = "用户名不能为空", groups = {LoginRule.class, RegisterRule.class})
    @Size(min = 3, max = 20, message = "用户名长度只能在3-20之间", groups = {LoginRule.class, RegisterRule.class})
    private String username;

    @NotBlank(message = "密码不能为空", groups = {LoginRule.class, RegisterRule.class})
    @Size(min = 6, max = 20, message = "密码长度只能在6-20之间", groups = {LoginRule.class, RegisterRule.class})
    private String password;

    @NotBlank(message = "昵称不能为空", groups = {RegisterRule.class})
    private String nickname;

    @NotBlank(message = "邮箱不能为空", groups = {RegisterRule.class})
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "邮件格式错误", groups = {RegisterRule.class})
    private String email;

    @NotBlank(message = "身份证号不能为空", groups = {RegisterRule.class})
    @IdCard(message = "身份证不合法", groups = {RegisterRule.class})
    private String idNumber;

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
