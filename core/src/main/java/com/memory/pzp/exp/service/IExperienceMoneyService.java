package com.memory.pzp.exp.service;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.business.domain.BidRequest;

/**
 * Created by wall on 2017/9/24.
 */
public interface IExperienceMoneyService {

    /***
     * 活动金发布
     * @param exMessage
     */
    void expPublish(BidRequest exMessage, Logininfo userBoss);

    /****
     * 获取活动金列表
     * @param qo
     * @return
     */
    PageResult queryExpMessage(BidRequestQueryObject qo);

    /***
     * 审核发布
     * @param id
     * @param remark
     * @param state
     * @param current
     */
    void auditI(long id, String remark, byte state, Logininfo current);
}
