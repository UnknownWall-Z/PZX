package com.memory.pzp.business.service;

import com.memory.pzp.business.domain.BidRequestAuditHistory;

/**
 * Created by wall on 2017/9/21.
 */
public interface IBidRequestAuditHistoryService {

    /***
     * 根据申请人查询借款申请审核
     * @param id
     * @return
     */
    java.util.List<BidRequestAuditHistory> listByUserId(long id);

}
