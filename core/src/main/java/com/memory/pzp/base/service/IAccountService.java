package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Account;

/**
 * Created by wall on 2017/9/12.
 */
public interface IAccountService {

    int insert(long userId);

    /***
     * 要处理乐观锁
     * @param account
     */
    void update(Account account);

    Account getByUserId(Long id);
}
