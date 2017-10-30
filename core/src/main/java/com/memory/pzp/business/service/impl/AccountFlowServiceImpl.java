package com.memory.pzp.business.service.impl;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.domain.AccountFlow;
import com.memory.pzp.business.domain.RechargeOffline;
import com.memory.pzp.business.mapper.AccountFlowMapper;
import com.memory.pzp.business.service.IAccountFlowService;
import com.memory.pzp.exp.domain.ExpAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wall on 2017/9/22.
 */
@Service
public class AccountFlowServiceImpl implements IAccountFlowService {

    @Autowired
    private AccountFlowMapper accountFlowMapper;

    private <T> AccountFlow createFlow(T account) {
        AccountFlow flow = new AccountFlow();
        long id = 0;
        BigDecimal usableAmount = new BigDecimal(0);
        BigDecimal freezedAmount = new BigDecimal(0);

        if(account instanceof ExpAccount){
            id = ((ExpAccount) account).getId();
            usableAmount = ((ExpAccount) account).getUsableAmount();
            freezedAmount = ((ExpAccount) account).getFreezedAmount();
        }else if (account instanceof Account) {
            id = ((Account) account).getId();
            usableAmount = ((Account) account).getUsableAmount();
            freezedAmount = ((Account) account).getFreezedAmount();
        }

        flow.setActionTime(new Date());
        flow.setAccountId(id);
        flow.setBalance(usableAmount);
        flow.setFreezed(freezedAmount);
        return flow;
    }

    @Override
    public void save(Account account, RechargeOffline re) {
        AccountFlow flow = createFlow(account);
        flow.setAccountActionType(Consts.ACCOUNT_ACTIONTYPE_RECHARGE_OFFLINE);
        flow.setAmount(re.getAmount());
        flow.setNote("线下充值:" + re.getAmount() + " 成功!");
        accountFlowMapper.insert(flow);
    }

    @Override
    public void bidFlow(Account bidAccount, BigDecimal amount) {
        AccountFlow flow = createFlow(bidAccount);
        flow.setAccountActionType(Consts.ACCOUNT_ACTIONTYPE_BID_FREEZED);
        flow.setAmount(amount);
        flow.setNote("投标金额:" + amount + " 成功!");
        accountFlowMapper.insert(flow);
    }

    @Override
    public void expBidFlow(ExpAccount expAccount, BigDecimal remainder) {
        AccountFlow flow = createFlow(expAccount);
        flow.setAccountActionType(Consts.EXPACCOUNT_ACTIONTYPE_BID_FREEZED);
        flow.setAmount(remainder);
        flow.setNote("投标活动金额:" + remainder + " 成功!");
        accountFlowMapper.insert(flow);
    }

}
