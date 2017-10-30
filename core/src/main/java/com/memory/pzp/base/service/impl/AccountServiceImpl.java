package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.mapper.AccountMapper;
import com.memory.pzp.base.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wall on 2017/9/12.
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int insert(long userId) {
        Account account = new Account();
        account.setId(userId);
        return accountMapper.insert(account);
    }

    @Override
    public void update(Account account) {
        int ret = accountMapper.updateByPrimaryKey(account);
        if(ret<=0){
            throw new RuntimeException("乐观锁失败"+account.getId());
        }
    }

    @Override
    public Account getByUserId(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }
}
