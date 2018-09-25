package com.jianjieming.homework.service;

import com.jianjieming.homework.bean.UserBean;
import com.jianjieming.homework.dao.UserDaoImpl;
import com.jianjieming.homework.exception.JsonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 铭
 * 2018/9/25 10:24
 */
@Service
public class UserService {
    @Resource
    private UserDaoImpl userDao;

    public boolean showAll(UserBean userBean) {
        List<UserBean> userBeans = userDao.queryUser();
        for (UserBean bean : userBeans) {
            if (userBean.getUsername().equals(bean.getUsername()) && userBean.getPassword().equals(bean.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
        throw new JsonException("服务器错误", 404);
    }

}
