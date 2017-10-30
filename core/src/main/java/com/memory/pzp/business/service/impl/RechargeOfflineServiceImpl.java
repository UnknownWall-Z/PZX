package com.memory.pzp.business.service.impl;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RechargeOfflineQueryObject;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.business.domain.RechargeOffline;
import com.memory.pzp.business.mapper.RechargeOfflineMapper;
import com.memory.pzp.business.service.IAccountFlowService;
import com.memory.pzp.business.service.IRechargeOfflineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RechargeOfflineServiceImpl implements IRechargeOfflineService {

    @Autowired
    private IAccountFlowService accountFlowService;
	@Autowired
	private RechargeOfflineMapper rechargeMapper;
	@Autowired
	private IAccountService accountService;

	@Override
	public PageResult query(RechargeOfflineQueryObject qo) {
		int count = this.rechargeMapper.count(qo);
		if (count > 0) {
			List<RechargeOffline> list = this.rechargeMapper.listData(qo);
			return new PageResult(list, count, qo.getCurrentPage(), qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

	@Override
	public void rechargAudit(long id, String remark, int state, Logininfo current) {
		RechargeOffline re = this.rechargeMapper.selectByPrimaryKey(id);
        if(re!=null && re.getState()== RechargeOffline.STATE_NORMAL){
			re.setAuditor(current);
			re.setAuditTime(new Date());
			re.setRemark(remark);
			re.setState((byte)state);
			if(state==RechargeOffline.STATE_PASS){
                Account account = accountService.getByUserId(re.getApplier().getId());
                account.setUsableAmount(account.getUsableAmount().add(re.getAmount()));
                accountFlowService.save(account,re);
                accountService.update(account);
            }
            rechargeMapper.updateByPrimaryKey(re);
		}
	}

	@Override
	public void apply(RechargeOffline ro,Logininfo user) {
		RechargeOffline r = new RechargeOffline();
		r.setAmount(ro.getAmount());
		r.setApplier(user);
		r.setApplyTime(new Date());
		r.setBankinfo(ro.getBankinfo());
		r.setNote(ro.getNote());
		r.setTradeTime(ro.getTradeTime());
		r.setState(RechargeOffline.STATE_NORMAL);
		r.setTradeCode(ro.getTradeCode());
		this.rechargeMapper.insert(r);
	}


}
