package com.jianjieming.study.dao;

import com.jianjieming.study.bean.PersonBean;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/10 上午9:40
 */
public interface PersonDao {

    List<PersonBean> findAll();

    List<PersonBean> findName(String name);

    void insertPersonList(List<PersonBean> personBeans);

    List<PersonBean> findNameOrSex(PersonBean personBean);

    void deleteAll(int id);

    void updatePerson(PersonBean personBean);

}
