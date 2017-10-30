package com.memory.pzp.business.service;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RechargeOfflineQueryObject;
import com.memory.pzp.business.domain.RechargeOffline;

/**
 * 线下充值服务
 * 
 * @author xmg
 *
 */
public interface IRechargeOfflineService {

	/**
	 * 线下充值申请
	 * 
	 * @param ro
	 */
	void apply(RechargeOffline ro,Logininfo user);

	PageResult query(RechargeOfflineQueryObject qo);

	/***
	 * 线下充值审核
	 * @param id
	 * @param remark
	 * @param state
	 * @param current
	 */
    void rechargAudit(long id, String remark, int state, Logininfo current);
}
