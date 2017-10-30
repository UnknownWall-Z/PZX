package com.memory.pzp.business.service;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.business.domain.BidRequest;

import java.math.BigDecimal;

/**
 * Created by wall on 2017/9/20.
 */
public interface IBidRequestService {

    /***
     * 保存活动金发布
     * @param er
     */
    void saveExpPublish(BidRequest er);
    /**
     * 保存借款申请数据
     * @param bidRequest
     */
    void saveBidRequestApply(BidRequest bidRequest, long id, Account account);

    /***
     * 乐观锁+更新
     * @param bidRequest
     */
    void update(BidRequest bidRequest);

    /***
     * 单独活动金列表
     * @param qo
     * @return
     */
    PageResult expQuery(BidRequestQueryObject qo);

    /***
     * 活动金投标
     * @param amount
     * @param bidRequestId
     * @param current
     */
    void expBid(BigDecimal amount, long bidRequestId, Logininfo current);

    PageResult query(BidRequestQueryObject qo);

    /***
     * 保存一条借款申请审核
     * @param id
     * @param remark
     * @param state
     * @param current
     */
    void saveAudit(long id, String remark, int state, Logininfo current);

    /***
     * 根据借款申请id查询列表
     * @param id
     * @return
     */
    BidRequest get(long id);

    /**
     * 查询所有通过审核的借款申请
     * 按照投标中>还款中>已完成的顺序排列
     * @param qo
     * @return
     */
    java.util.List<BidRequest> bidding(BidRequestQueryObject qo);

    /***
     * 投资数据保存
     * @param amount
     * @param bidRequestId
     * @param current
     */
    void firstBid(BigDecimal amount, long bidRequestId, Logininfo current);

    /***
     * 投标审核
     * @param id
     * @param remark
     * @param state
     */
    void BidAudit(long id, String remark, byte state,Logininfo current);

    /***
     * 审核前操作
     * @return
     */
    PageResult auditHandle(BidRequestQueryObject qo);

}
