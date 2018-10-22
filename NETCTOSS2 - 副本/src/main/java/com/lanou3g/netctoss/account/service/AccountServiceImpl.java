package com.lanou3g.netctoss.account.service;

import com.lanou3g.netctoss.account.mapper.AccountMapper;
import com.lanou3g.netctoss.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Transactional
    @Override
    public int updateStart(Integer accountId) {
        return accountMapper.updateStart(accountId);
    }

    @Transactional
    @Override
    public int updateStop(Integer accountId) {
        return accountMapper.updateStop(accountId);
    }

    @Transactional
    @Override
    public int updateOne(Account account) {
        return accountMapper.updateOne(account);
    }

    @Override
    public Account showMessage(Integer accountId) {
        return accountMapper.showMessage(accountId);
    }

    @Transactional
    @Override
    public int deleteOne(Integer accountId) {
        return accountMapper.deleteOne(accountId);
    }

    @Transactional
    @Override
    public int insertOne(Account account) {
        return accountMapper.insertOne(account);
    }

    @Override
    public List<Account> selectOne(Account account) {
        return accountMapper.selectOne(account);
    }

    @Override
    public List<Account> selectOneByMessage(Account account) {
        return accountMapper.selectOneByMessage(account);
    }

    @Override
    public Account selectOneById(Integer accountId) {
        return accountMapper.selectOneById(accountId);
    }

    @Override
    public List<Account> selectPage(Integer page) {
        return accountMapper.selectPage(page);
    }
}
