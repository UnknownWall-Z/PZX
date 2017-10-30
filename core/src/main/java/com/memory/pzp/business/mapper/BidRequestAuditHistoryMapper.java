package com.memory.pzp.business.mapper;

import com.memory.pzp.business.domain.BidRequestAuditHistory;

import java.util.List;

public interface BidRequestAuditHistoryMapper {

    int insert(BidRequestAuditHistory record);

    List<BidRequestAuditHistory> listByUserId(long id);
}