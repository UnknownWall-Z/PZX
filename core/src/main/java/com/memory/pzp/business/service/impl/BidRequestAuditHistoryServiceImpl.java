package com.memory.pzp.business.service.impl;

import com.memory.pzp.business.domain.BidRequestAuditHistory;
import com.memory.pzp.business.mapper.BidRequestAuditHistoryMapper;
import com.memory.pzp.business.service.IBidRequestAuditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wall on 2017/9/21.
 */
@Service
public class BidRequestAuditHistoryServiceImpl implements IBidRequestAuditHistoryService{

    @Autowired
    private BidRequestAuditHistoryMapper historyMapper;

    @Override
    public List<BidRequestAuditHistory> listByUserId(long id) {
        return historyMapper.listByUserId(id);
    }
}
