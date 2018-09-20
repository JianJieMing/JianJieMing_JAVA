package com.jianjieming.study;

import com.jianjieming.study.bean.PersonBean;
import com.jianjieming.study.dao.PersonDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/10 下午5:25
 */
public class TestDemo {

    private SqlSession sqlSession;

    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        List<PersonBean> all = personDao.findAll();
        for (PersonBean personBean : all) {
            System.out.println(personBean);
        }
        System.out.println("**********");
        List<PersonBean> name = personDao.findName("七");
        for (PersonBean bean : name) {
            System.out.println(bean);
        }
        System.out.println("**********");
        List<PersonBean> beans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beans.add(new PersonBean(66 + i, "鸣人之多重影分身" + i + "号", "男"));
        }
        personDao.insertPersonList(beans);

        PersonBean personBean = new PersonBean();
        personBean.setName("王五");
        List<PersonBean> nameOrSex = personDao.findNameOrSex(personBean);
        for (PersonBean orSex : nameOrSex) {
            System.out.println(orSex);
        }
        System.out.println("**********");
        personDao.deleteAll(8);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}
