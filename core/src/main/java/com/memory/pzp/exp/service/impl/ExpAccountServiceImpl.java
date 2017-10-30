package com.memory.pzp.exp.service.impl;

import com.memory.pzp.base.util.Consts;
import com.memory.pzp.exp.domain.ExpAccount;
import com.memory.pzp.exp.domain.ExpAccountFlow;
import com.memory.pzp.exp.domain.ExpAccountGrantrecord;
import com.memory.pzp.exp.mapper.ExpAccountFlowMapper;
import com.memory.pzp.exp.mapper.ExpAccountGrantrecordMapper;
import com.memory.pzp.exp.mapper.ExpAccountMapper;
import com.memory.pzp.exp.service.IExpAccountService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by wall on 2017/9/24.
 */
@Service
@Transactional
public class ExpAccountServiceImpl implements IExpAccountService{

    @Autowired
    private ExpAccountMapper expACcountMapper;
    @Autowired
    private ExpAccountGrantrecordMapper grantrecordMapper;
    @Autowired
    private ExpAccountFlowMapper expAccountFlowMapper;

    @Override
    public void insert(long userId) {
        ExpAccount expAccount = new ExpAccount();
        ExpAccountGrantrecord expAccountGrantrecord = new ExpAccountGrantrecord();
        ExpAccountFlow expFlow = new ExpAccountFlow();
        expFlow.setActionTime(new Date());
        expFlow.setActionType(Consts.EXP_REGISTER_TYPE);
        expFlow.setAmount(Consts.EXP_REGISTER_MONEY);
        expFlow.setExpAccountId(userId);
        expFlow.setNote("注册送活动金");
        expAccount.setId(userId);
        expAccount.setUsableAmount(Consts.EXP_REGISTER_MONEY);
        expAccountGrantrecord.setAmount(Consts.EXP_REGISTER_MONEY);
        expAccountGrantrecord.setGrantDate(new Date());
        expAccountGrantrecord.setGrantType(Consts.EXP_REGISTER_TYPE);
        expAccountGrantrecord.setReturnDate(DateUtils.addMonths(new Date(),1));
        expAccountGrantrecord.setGrantUserId(userId);
        expAccountGrantrecord.setNote("注册送活动金");
        expAccountGrantrecord.setState(ExpAccountGrantrecord.STATE_MORMAL);
        expFlow.setUsableAmount(Consts.EXP_REGISTER_MONEY);
        expFlow.setFreezedAmount(expAccount.getFreezedAmount());
        expAccountFlowMapper.insert(expFlow);
        expACcountMapper.insert(expAccount);
        grantrecordMapper.insert(expAccountGrantrecord);
    }

    @Override
    public ExpAccount getByUserId(long id) {
        return expACcountMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(ExpAccount expAccount) {

        int ret = expACcountMapper.updateByPrimaryKey(expAccount);
        if(ret<=0){
            throw new RuntimeException("乐观锁失败"+expAccount.getId());
        }

    }
}
