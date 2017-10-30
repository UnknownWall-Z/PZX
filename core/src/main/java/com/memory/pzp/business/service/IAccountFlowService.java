package com.memory.pzp.business.service;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.domain.RechargeOffline;
import com.memory.pzp.exp.domain.ExpAccount;

import java.math.BigDecimal;

/**
 * Created by wall on 2017/9/22.
 */
public interface IAccountFlowService {
    /**
     * 活动标流水
     * @param expAccount
     * @param remainder
     */
    void expBidFlow(ExpAccount expAccount, BigDecimal remainder);

    void save(Account account, RechargeOffline re);

    void bidFlow(Account bidAccount, BigDecimal amount);

}
