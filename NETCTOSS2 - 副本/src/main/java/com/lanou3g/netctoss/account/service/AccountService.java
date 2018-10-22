package com.lanou3g.netctoss.account.service;

import com.lanou3g.netctoss.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    int updateStart(Integer accountId);

    int updateStop(Integer accountId);

    int updateOne(Account account);

    Account showMessage (Integer accountId);

    int deleteOne(Integer accountId);

    int insertOne(Account account);

    List<Account> selectOne (Account account);

    List<Account> selectOneByMessage(Account account);

    Account selectOneById(Integer accountId);

    List<Account> selectPage (Integer page);
}
