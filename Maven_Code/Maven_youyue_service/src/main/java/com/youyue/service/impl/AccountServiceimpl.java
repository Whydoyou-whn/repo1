package com.youyue.service.impl;


import com.youyue.dao.IAccountDao;
import com.youyue.domain.Account;
import com.youyue.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(transactionManager = "transactionManager")
@EnableTransactionManagement
public class AccountServiceimpl implements AccountService {

    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层执行了");
        return dao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        dao.saveAccount(account);
        //手动设置错误
        //int i=1/0;
    }
}
